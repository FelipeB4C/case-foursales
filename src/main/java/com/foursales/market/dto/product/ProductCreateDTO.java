package com.foursales.market.dto.product;

import com.foursales.market.model.Product;

import java.math.BigDecimal;

public class ProductCreateDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Integer inStock;


    public ProductCreateDTO(String name, String description, BigDecimal price, String category, Integer inStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category.toUpperCase();
        this.inStock = inStock;
    }

    public Product toModel(){
        return new Product(this.name, this.description, this.price, this.category, this.inStock);
    }
}
