package com.cnu.coffee.Product;

import com.cnu.coffee.Dto.ProductDto;
import com.cnu.coffee.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/new-product", method = RequestMethod.POST)
    public Product setProduct(@RequestBody ProductDto productDto) {
        return service.setProduct(productDto);
    }

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String input) {
        return service.searchProducts(input);
    }
}
