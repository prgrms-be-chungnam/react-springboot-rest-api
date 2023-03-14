package com.cnu.coffee.product;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductMapRepository implements ProductRepository {

    private final Map<UUID, Product> db = new HashMap<>();

    @Override
    public Product insert(Product product) {
        db.put(product.getProductId(), product);
        return db.get(product.getProductId());
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>(db.values());
        return products;
    }

    @Override
    public Product findById(UUID id) {
        return db.get(id);
    }

    @Override
    public Product update(Product product) {
        return db.replace(product.getProductId(), product);
    }

    @Override
    public void deleteById(UUID id) {
        db.remove(id);
    }

    @Override
    public void deleteAll() {
        db.clear();
    }
}
