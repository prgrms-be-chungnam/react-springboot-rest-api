package com.cnu.coffee.Product;

import com.cnu.coffee.Dto.ProductDto;
import com.cnu.coffee.EntityConverter;
import com.cnu.coffee.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository repository;

    @Autowired
    EntityConverter entityConverter;

    public Product setProduct(ProductDto productDto) {
        Product product = entityConverter.dtoToProduct(productDto);
        Date now = new Date(System.currentTimeMillis());
        product.setCreatedDate(now);
        product.setUpdatedDate(now);
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public List<Product> searchProducts(String input) {
        return repository.findProductsByNameContainingOrDescriptionContaining(input, input);
    }
}
