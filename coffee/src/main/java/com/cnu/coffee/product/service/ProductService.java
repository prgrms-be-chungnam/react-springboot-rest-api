package com.cnu.coffee.product.service;

import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.domain.ProductDTO;
import com.cnu.coffee.product.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository productRepository;

    public Product insertProduct(ProductDTO productDTO) {
        Product product = new Product(UUID.randomUUID(),
                productDTO.getName(),
                productDTO.getCategory(),
                productDTO.getPrice());
        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product update(UUID id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(ProductService.class.getPackage().getName()));
        product.setProductName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setLastUpdatedDate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        return productRepository.save(product);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
