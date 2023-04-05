package com.cnu.coffee.Product;

import com.cnu.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    public List<Product> findProductsByNameContainingOrDescriptionContaining(String name, String description);
}
