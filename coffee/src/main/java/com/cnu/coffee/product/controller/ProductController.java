package com.cnu.coffee.product.controller;

import com.cnu.coffee.product.domain.ProductResponseDto;
import com.cnu.coffee.product.service.ProductService;
import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.domain.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    // 상품 추가
    @PostMapping("/add")
    public ProductResponseDto insertProduct(@RequestBody ProductRequestDto productRequestDTO){
        return productService.insertProduct(productRequestDTO);
    }

    // 상품 전체 리스트
    @GetMapping("/getAll")
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    // 상품 조회
    @GetMapping("/get/{productId}")
    public ProductResponseDto getProduct(@PathVariable("productId") UUID id){
        return productService.findById(id);
    }

    // 상품 정보 업데이트
    @PutMapping("/update/{productId}")
    public ProductResponseDto update(@PathVariable("productId") UUID id, @RequestBody ProductRequestDto productRequestDTO){
        return productService.updateProduct(id, productRequestDTO);
    }

    // 상품 삭제
    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") UUID id){
        productService.deleteProduct(id);
    }

    // 상품 전체 삭제(개발용)
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        productService.deleteAllProducts();
    }
}
