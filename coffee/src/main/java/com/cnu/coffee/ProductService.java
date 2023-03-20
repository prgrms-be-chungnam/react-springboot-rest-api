package com.cnu.coffee;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(ProductDto productDto) {
        return productRepository.save(productDto.toEntity());
    }
}
