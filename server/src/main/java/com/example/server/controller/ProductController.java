package com.example.server.controller;

import com.example.server.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")    //db에 있는 product 모두 보여주기
    public String productsPage(Model model) {
        var product = productService.getAllProducts();
        model.addAttribute("product", product);
        return "product-list";
    }

    @GetMapping("new-product")  //product  작성페이지 이동
    public String newProductPage() {
        return "new-product";
    }

    @PostMapping("/product")   //db에 product 저장
    public String newProduct(CreateProductRequest createProductRequest) {
        productService.createProduct(
                createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.description());
        return "redirect:/product";
    }
    @GetMapping("/product/{id}")
    public String product(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProcutById(id));
        return "/detail";
    }
    @GetMapping("/product/update/{id}")
    public String noticeUpdate(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProcutById(id));
        return "/update";
    }
    @RequestMapping(path = "/delete/product/{id}", method = {RequestMethod.DELETE,RequestMethod.POST})
    public String deleteProduct(@PathVariable UUID id){
        productService.deleteById(id);
        return "redirect:/product";
    }

}
