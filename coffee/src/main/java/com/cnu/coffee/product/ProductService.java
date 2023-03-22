package com.cnu.coffee.product;

import com.cnu.coffee.exeption.DescriptionNotFoundException;
import com.cnu.coffee.exeption.ProductNotFoundException;
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
        Optional<String> dercription = Optional.ofNullable(product.getDescription());

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .category(product.getCategory())
                .price(product.getPrice())
                .description(dercription)
                .registeredDate(product.getRegisteredDate())
                .lastUpdatedDate(product.getLastUpdatedDate())
                .build();

        return productResponseDto;
    }

    public ProductResponseDto insertProduct(ProductRequestDto productRequestDto){
        Product product = Product.builder()
                .productName(productRequestDto.getProductName())
                .category(productRequestDto.getCategory())
                .price(productRequestDto.getPrice())
                .description(productRequestDto.getDescription().orElseThrow(DescriptionNotFoundException::new))
                .lastUpdatedDate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .registeredDate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .build();

        Product savedProduct = productRepository.save(product);
        return this.convertEntityToDto(savedProduct);
    }

    public List<ProductResponseDto> findAllProducts() {
        Iterator<Product> productIterator = productRepository.findAll().iterator();
        List<ProductResponseDto> dtoList = new ArrayList<>();

        while (productIterator.hasNext()){
            dtoList.add(
                    this.convertEntityToDto(productIterator.next())
            );
        }

        return dtoList;
    }

    public ProductResponseDto findById(UUID id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("No such product id " + id)
        );
        return this.convertEntityToDto(product);
    }


    public ProductResponseDto updateProduct(UUID id, ProductRequestDto productRequestDTO) throws ProductNotFoundException {
        Product foundProduct = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("No such product id " + id)
        );

        Product product = Product.builder()
                .id(foundProduct.getId())
                .productName(productRequestDTO.getProductName())
                .category(productRequestDTO.getCategory())
                .price(productRequestDTO.getPrice())
                .description(productRequestDTO.getDescription().orElseThrow(DescriptionNotFoundException::new))
                .lastUpdatedDate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .registeredDate(foundProduct.getRegisteredDate())
                .build();

        Product savedProduct = productRepository.save(product);

        return this.convertEntityToDto(savedProduct);
    }

    public void deleteProduct(UUID id) throws ProductNotFoundException {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }


}
