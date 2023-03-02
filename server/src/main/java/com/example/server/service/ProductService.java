package com.example.server.service;

import com.example.server.model.Category;
import com.example.server.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getProductsByCategory(Category category);

    List<Product> getAllProducts();

    Product createProduct(String productName, Category category, long price);

    Product createProduct(String productName, Category category, long price, String description);

    Product getProcutById(UUID uuid);

    void deleteById(UUID uuid);


}
