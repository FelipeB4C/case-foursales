package com.foursales.market.service;

import com.foursales.market.dto.product.ProductCreateDTO;
import com.foursales.market.dto.product.ProductDetailDTO;
import com.foursales.market.dto.product.ProductUpdateDTO;
import com.foursales.market.model.Product;
import com.foursales.market.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public ProductDetailDTO insertProduct(ProductCreateDTO request) {
        Product newProduct = request.toModel();
        Product response = repository.save(newProduct);
        return new ProductDetailDTO(response);
    }

    public List<ProductDetailDTO> listAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(ProductDetailDTO::new).toList();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public ProductDetailDTO updateProduct(ProductUpdateDTO request, UUID id) {
        Product product = repository.findById(id).get();
        request.updateData(product);
        repository.save(product);
        return new ProductDetailDTO(product);
    }


}
