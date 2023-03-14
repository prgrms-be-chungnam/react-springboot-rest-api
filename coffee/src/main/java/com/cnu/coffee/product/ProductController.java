package com.cnu.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/new")
    public Product insertProduct(@RequestBody ProductDTO productDTO){
        return productService.insertProduct(productDTO);
    }

    @GetMapping("/all")
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @PutMapping("/update/{productId}")
    public Product update(@PathVariable("productId") UUID id, @RequestBody ProductDTO productDTO){
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") UUID id){
        productService.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        productService.deleteAll();
    }
}
