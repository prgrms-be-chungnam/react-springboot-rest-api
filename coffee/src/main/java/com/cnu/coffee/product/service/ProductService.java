package com.cnu.coffee.product.service;

import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.domain.ProductRequestDto;
import com.cnu.coffee.product.domain.ProductResponseDto;
import com.cnu.coffee.product.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository productRepository;

    private ProductResponseDto convertEntityToDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto(
                product.getId(),
                product.getProductName(),
                product.getCategory(),
                product.getPrice(),
                product.getRegisteredDate(),
                product.getLastUpdatedDate()
        );

        Optional<String> dercription = Optional.ofNullable(product.getDescription());
        if (dercription.isPresent()){
            productResponseDto.setDescription(dercription);
        }
        return productResponseDto;
    }

    public ProductResponseDto insertProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(
                productRequestDto.getProductName(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice());
        if (productRequestDto.getDescription().isPresent()){
            product.setDescription(productRequestDto.getDescription().get());
        }
        Product savedProduct = productRepository.save(product);
        return this.convertEntityToDto(savedProduct);
    }

    public List<ProductResponseDto> getAllProducts() {
        Iterator<Product> productIterator = productRepository.findAll().iterator();
        List<ProductResponseDto> dtoList = new ArrayList<>();

        while (productIterator.hasNext()){
            dtoList.add(
                    this.convertEntityToDto(productIterator.next())
            );
        }

        return dtoList;
    }


    public ProductResponseDto updateProduct(UUID id, ProductRequestDto productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);

        product.setProductName(productRequestDTO.getProductName());
        product.setCategory(productRequestDTO.getCategory());
        product.setPrice(productRequestDTO.getPrice());
        product.setLastUpdatedDate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        if (productRequestDTO.getDescription().isPresent()){
            product.setDescription(productRequestDTO.getDescription().get());
        }

        Product savedProduct = productRepository.save(product);

        return this.convertEntityToDto(savedProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public ProductResponseDto findById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return this.convertEntityToDto(product);
    }
}
