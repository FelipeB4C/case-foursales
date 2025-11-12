package com.foursales.market.service;

import com.foursales.market.Enum.OrderStatus;
import com.foursales.market.dto.order.OrderRequestDTO;
import com.foursales.market.exception.ValidationException;
import com.foursales.market.model.Order;
import com.foursales.market.model.OrderItem;
import com.foursales.market.model.Product;
import com.foursales.market.model.User;
import com.foursales.market.repository.OrderRepository;
import com.foursales.market.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public Order createOrder(OrderRequestDTO request, User currentUser) {
        Order newOrder = new Order(currentUser, OrderStatus.PENDENTE);

        boolean hasStockIssues = false;

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalValue = BigDecimal.ZERO;

        for (var itemDTO : request.items()) {
            Product product = productRepository.findById(itemDTO.id())
                    .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + itemDTO.id() + " não encontrado."));

            if (product.getInStock() < itemDTO.quantity()) {
                hasStockIssues = true;
            }

            OrderItem orderItem = new OrderItem(newOrder, product, itemDTO.quantity(), product.getPrice());
            orderItems.add(orderItem);

            totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(itemDTO.quantity())));
        }

        newOrder.setItems(orderItems);
        newOrder.setTotalValue(totalValue);

        if (hasStockIssues) {
            newOrder.setStatus(OrderStatus.CANCELADO);
        }

        return orderRepository.save(newOrder);
    }

    public Order processPayment(UUID orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido com ID " + orderId + " não encontrado."));

        if (order.getStatus() != OrderStatus.PENDENTE) {
            throw new IllegalStateException("Apenas pedidos PENDENTES podem ser pagos.");
        }

        List<String> stockErrors = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();

            if (product.getInStock() < item.getQuantity()) {
                String errorMsg = String.format(
                        "Estoque insuficiente para '%s'. (Pedido: %d, Disponível: %d)",
                        product.getName(), item.getQuantity(), product.getInStock()
                );
                stockErrors.add(errorMsg);
            }
        }

        if (!stockErrors.isEmpty()) {
            order.setStatus(OrderStatus.CANCELADO);
            orderRepository.save(order);
            throw new ValidationException(stockErrors);
        }

        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            int newStock = product.getInStock() - item.getQuantity();
            product.setInStock(newStock);
            productRepository.save(product);
        }

        order.setStatus(OrderStatus.APROVADO);
        return orderRepository.save(order);
    }

    private static List<String> getStrings(Order order) {
        List<String> stockErrors = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();

            if (product.getInStock() < item.getQuantity()) {
                String errorMsg = String.format(
                        "Estoque insuficiente para '%s'. (Pedido: %d, Disponível: %d)",
                        product.getName(), item.getQuantity(), product.getInStock()
                );
                stockErrors.add(errorMsg);
            }
        }
        return stockErrors;
    }

    public List<Order> findOrdersByUser(User currentUser) {
        return orderRepository.findByConsumer(currentUser);
    }

}
