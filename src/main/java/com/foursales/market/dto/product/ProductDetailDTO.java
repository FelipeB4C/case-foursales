package com.foursales.market.dto.product;

import com.foursales.market.model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDetailDTO {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Integer inStock;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;


    public ProductDetailDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.inStock = product.getInStock();
        this.createdAt = product.getCreatedAt();
        this.lastUpdatedAt = product.getLastUpdatedAt();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getInStock() {
        return inStock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

}
