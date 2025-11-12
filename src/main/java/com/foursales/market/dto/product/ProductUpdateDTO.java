package com.foursales.market.dto.product;

import com.foursales.market.model.Product;

import java.math.BigDecimal;

public class ProductUpdateDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Integer inStock;

    public ProductUpdateDTO(String name, String description, BigDecimal price, String category, Integer inStock){
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category.toUpperCase();
        this.inStock = inStock;
    }

    public void updateData(Product product) {
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategory(this.category);
        product.setInStock(this.inStock);
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

}
