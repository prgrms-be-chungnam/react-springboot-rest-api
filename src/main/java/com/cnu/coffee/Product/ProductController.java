package com.cnu.coffee.Product;

import com.cnu.coffee.Dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/new-product", method = RequestMethod.POST)
    public ProductDto setProduct(@RequestBody ProductDto productDto) {
        return service.setProduct(productDto);
    }

    @RequestMapping("/products")
    public List<ProductDto> getProducts() {
        return service.getProducts();
    }

    @RequestMapping(value = "/delete-product", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestParam("id") long productId){
        service.deleteProduct(productId);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(@RequestParam String input) {
        return service.searchProducts(input);
    }
}
