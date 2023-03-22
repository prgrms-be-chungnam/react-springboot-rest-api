package com.cnu.coffee.product.repository;

import com.cnu.coffee.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository {
    Product insert(Product product);
    List<Product> findAll();
    Product findById(UUID id);
//    Product findByName(String name);
    Product update(Product product);
    void deleteById(UUID id);
    void deleteAll();

}
