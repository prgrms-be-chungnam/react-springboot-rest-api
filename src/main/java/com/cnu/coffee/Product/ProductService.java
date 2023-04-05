package com.cnu.coffee.Product;

import com.cnu.coffee.Dto.ProductDto;
import com.cnu.coffee.entity.Product;
import com.cnu.coffee.Product.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository repository;

    public Product setProduct(ProductDto productDto) {
        Product product = dtoToProduct(productDto);
        Date now = new Date(System.currentTimeMillis());
        product.setCreatedDate(now);
        product.setUpdatedDate(now);
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    private Product dtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public List<Product> searchProducts(String input) {
        return repository.findProductsByNameContainingOrDescriptionContaining(input, input);
    }
}
