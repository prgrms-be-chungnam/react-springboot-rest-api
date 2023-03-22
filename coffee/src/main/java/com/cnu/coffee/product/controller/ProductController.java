package com.cnu.coffee.product.controller;

import com.cnu.coffee.product.service.ProductService;
import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.domain.ProductDTO;
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
    public Product insertProduct(@RequestBody ProductDTO productDTO){
        return productService.insertProduct(productDTO);
    }

    // 상품 전체 리스트
    @GetMapping("/getAll")
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    // 상품 정보 업데이트
    @PutMapping("/update/{productId}")
    public Product update(@PathVariable("productId") UUID id, @RequestBody ProductDTO productDTO){
        return productService.update(id, productDTO);
    }

    // 상품 삭제
    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") UUID id){
        productService.delete(id);
    }

    // 상품 전체 삭제(개발용)
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        productService.deleteAll();
    }
}
