package com.cnu.coffee.product;

import com.cnu.coffee.product.domain.Category;
import com.cnu.coffee.product.domain.ProductRequestDto;
import com.cnu.coffee.product.domain.ProductResponseDto;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;


@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    public static final Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    ProductService productService;

    ProductResponseDto product;

    @Test
    @Order(1)
    @DisplayName("상품 등록")
    void testInsert(){
        ProductRequestDto productRequestDTO = ProductRequestDto.builder()
                .productName("test-coffee-product")
                .category(Category.COFFEE_BEAN)
                .price(1000)
                .description(Optional.of(""))
                .build();

        this.product = productService.insertProduct(productRequestDTO);

        logger.info("inserted -> {}", product);
    }

    @Test
    @Order(2)
    @DisplayName("단일 상품, 전체 상품 조회")
    void testFindProduct(){
        ProductRequestDto productRequestDTO = ProductRequestDto.builder()
                .productName("test-coffee-product2")
                .category(Category.COFFEE_CAPSULE)
                .price(1500)
                .description(Optional.of(""))
                .build();
        productService.insertProduct(productRequestDTO);

        logger.info("find one -> {}", productService.findById(this.product.getId()));
        logger.info("find all -> {}", productService.findAllProducts());
    }

    @Test
    @Order(3)
    @DisplayName("상품 정보 수정")
    void testUpdateProduct(){
        ProductRequestDto productRequestDTO = ProductRequestDto.builder()
                .productName("updated-coffee-product")
                .category(Category.COFFEE_BEAN)
                .price(2000)
                .description(Optional.of("맛있는 커피 원두입니다 ^_^"))
                .build();

        ProductResponseDto updated = productService.updateProduct(this.product.getId(), productRequestDTO);

        logger.info("updated -> {}", updated);
    }

    @Test
    @Order(4)
    @DisplayName("상품 삭제")
    void testDeleteProduct(){
        productService.deleteProduct(this.product.getId());
        logger.info("after deleted -> {}", productService.findAllProducts());
    }

    @Test
    @Order(5)
    @DisplayName("상품 전체 삭제")
    void testDeleteAllPrduct(){
        productService.deleteAllProducts();
        logger.info("after all products deleted -> {}", productService.findAllProducts());
    }

}