package com.foursales.market.controller;

import com.foursales.market.dto.product.ProductCreateDTO;
import com.foursales.market.dto.product.ProductDetailDTO;
import com.foursales.market.dto.product.ProductUpdateDTO;
import com.foursales.market.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Transactional
    @PostMapping("/insert")
    ResponseEntity<ProductDetailDTO> insertProduct(@RequestBody ProductCreateDTO request){
        ProductDetailDTO productDetailResponse = service.insertProduct(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productDetailResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(productDetailResponse);
    }

    @GetMapping("/all")
    ResponseEntity<List<ProductDetailDTO>> listAllProducts(){
        List<ProductDetailDTO> listAllProducts = service.listAllProducts();
        return ResponseEntity.ok().body(listAllProducts);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ProductDetailDTO> updateProduct(@RequestBody ProductUpdateDTO request, @PathVariable UUID id) {
        ProductDetailDTO updatedProduct = service.updateProduct(request, id);
        return ResponseEntity.ok().body(updatedProduct);
    }

}


