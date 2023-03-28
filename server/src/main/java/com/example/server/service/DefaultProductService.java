package com.example.server.service;

import com.example.server.model.Category;
import com.example.server.model.Product;
import com.example.server.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String productName, Category category, long price) {
       var product = new Product(UUID.randomUUID(), productName, category, price);
        return productRepository.insert(product);
    }

    @Override
    public Product createProduct(String productName, Category category, long price, String description) {
        var product = new Product(UUID.randomUUID(), productName, category, price, description, LocalDateTime.now(),LocalDateTime.now());
        return productRepository.insert(product);
    }

    @Override
    public Product getProcutById(UUID uuid) {
       return productRepository.findById(uuid).orElseThrow(()->
               new IllegalArgumentException("해당 글이 없습니다.id ="+uuid));
    }

    @Override
    public void deleteById(UUID uuid) {
       productRepository.deleteById(uuid);

    }


}
