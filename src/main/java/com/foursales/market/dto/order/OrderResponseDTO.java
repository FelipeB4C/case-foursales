package com.foursales.market.dto.order;

import com.foursales.market.Enum.OrderStatus;
import com.foursales.market.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderResponseDTO {

    private UUID orderId;
    private OrderStatus status;
    private BigDecimal totalValue;
    private List<OrderItemResponseDTO> items;

    public OrderResponseDTO(){}

    public OrderResponseDTO(Order order) {
        this.orderId = order.getId();
        this.status = order.getStatus();
        this.totalValue = order.getTotalValue();
        this.items = order.getItems().stream()
                .map(OrderItemResponseDTO::new)
                .collect(Collectors.toList());
    }


    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public List<OrderItemResponseDTO> getItems() {
        return items;
    }
}
