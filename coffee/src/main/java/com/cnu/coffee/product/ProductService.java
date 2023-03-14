package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product insertProduct(ProductDTO productDTO) {
        Product product = new Product(UUID.randomUUID(),
                productDTO.getName(),
                productDTO.getCategory(),
                productDTO.getPrice());
        return productRepository.insert(product);
    }


    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product update(UUID id, ProductDTO productDTO) {
        Product product = productRepository.findById(id);
        product.setProductName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setUpdatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        return productRepository.update(product);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
