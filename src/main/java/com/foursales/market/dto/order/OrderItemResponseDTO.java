package com.foursales.market.dto.order;

import com.foursales.market.model.OrderItem;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemResponseDTO {

    private UUID itemId;
    private UUID productId;
    private String productName;
    private Integer quantity;
    private BigDecimal priceAtOrder;


    public OrderItemResponseDTO(){}

    public OrderItemResponseDTO(OrderItem orderItem){
        this.itemId = orderItem.getId();
        this.productId = orderItem.getProduct().getId();
        this.productName = orderItem.getProduct().getName();
        this.quantity = orderItem.getQuantity();
        this.priceAtOrder = orderItem.getPriceAtOrder();
    }


    public UUID getItemId() {
        return itemId;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPriceAtOrder() {
        return priceAtOrder;
    }
}
