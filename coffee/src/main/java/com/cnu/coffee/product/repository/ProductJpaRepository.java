package com.cnu.coffee.product.repository;

import com.cnu.coffee.product.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Primary
public interface ProductJpaRepository extends JpaRepository<Product, UUID> {
}
