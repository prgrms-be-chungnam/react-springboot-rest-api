package com.cnu.coffee.product.service;

import com.cnu.coffee.product.domain.Category;
import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.domain.ProductRequestDto;
import com.cnu.coffee.product.domain.ProductResponseDto;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


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
        ProductRequestDto productRequestDTO = new ProductRequestDto(
                "test-coffee-product",
                Category.COFFEE_BEAN,
                1000
        );

        this.product = productService.insertProduct(productRequestDTO);

        logger.info("inserted -> {}", product);
    }

    @Test
    @Order(2)
    @DisplayName("단일 상품, 전체 상품 조회")
    void testFindProduct(){
        ProductRequestDto productRequestDTO = new ProductRequestDto(
                "test-coffee-product2",
                Category.COFFEE_DRIP,
                1500
        );
        productService.insertProduct(productRequestDTO);

        logger.info("find one -> {}", productService.findById(this.product.getId()));
        logger.info("find all -> {}", productService.getAllProducts());
    }

    @Test
    @Order(3)
    @DisplayName("상품 정보 수정")
    void testUpdateProduct(){
        ProductRequestDto productRequestDTO = new ProductRequestDto(
                "updated-coffee-product",
                Category.COFFEE_CAPSULE,
                3000
        );

        ProductResponseDto updated = productService.updateProduct(this.product.getId(), productRequestDTO);

        logger.info("updated -> {}", updated);
    }

    @Test
    @Order(4)
    @DisplayName("상품 삭제")
    void testDeleteProduct(){
        productService.deleteProduct(this.product.getId());
        logger.info("after deleted -> {}", productService.getAllProducts());
    }

    @Test
    @Order(5)
    @DisplayName("상품 전체 삭제")
    void testDeleteAllPrduct(){
        productService.deleteAllProducts();
        logger.info("after all products deleted -> {}", productService.getAllProducts());
    }

}