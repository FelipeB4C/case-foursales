package com.foursales.market.controller;

import com.foursales.market.dto.order.OrderRequestDTO;
import com.foursales.market.dto.order.OrderResponseDTO;
import com.foursales.market.exception.ValidationException;
import com.foursales.market.model.Order;
import com.foursales.market.model.User;
import com.foursales.market.repository.UserRepository;
import com.foursales.market.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    public OrderController(OrderService orderService, UserRepository userRepository) {
        this.orderService = orderService;
        this.userRepository = userRepository;
    }

    @Transactional
    @PostMapping("/{username}")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request, @PathVariable String username) {

        User user = userRepository.findByUsername(username);

        Order createdOrder = orderService.createOrder(request, user);
        OrderResponseDTO responseDTO = new OrderResponseDTO(createdOrder);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(responseDTO.getOrderId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }


    @Transactional(noRollbackFor = ValidationException.class)
    @PostMapping("/pay/{orderId}")
    public ResponseEntity<OrderResponseDTO> processPayment(@PathVariable UUID orderId) {
        Order paidOrder = orderService.processPayment(orderId);
        OrderResponseDTO responseDTO = new OrderResponseDTO(paidOrder);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(responseDTO.getOrderId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping("/my-orders/{username}")
    public ResponseEntity<List<OrderResponseDTO>> getMyOrders(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        List<Order> orders = orderService.findOrdersByUser(user);

        List<OrderResponseDTO> responseDTOs = orders.stream()
                .map(OrderResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(responseDTOs);
    }
}
