package com.cnu.coffee.product.repository;

import com.cnu.coffee.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductMapRepository implements ProductRepository {

    private final Map<UUID, Product> db = new HashMap<>();

    @Override
    public Product insert(Product product) {
        db.put(product.getId(), product);
        return db.get(product.getId());
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
        return db.replace(product.getId(), product);
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
