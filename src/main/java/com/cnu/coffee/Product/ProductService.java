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

    public ProductDto setProduct(ProductDto productDto) {
        Product product = entityConverter.dtoToProduct(productDto);
        Date now = new Date(System.currentTimeMillis());
        product.setCreatedDate(now);
        product.setUpdatedDate(now);
        return entityConverter.productToDto(repository.save(product));
    }

    public List<ProductDto> getProducts() {
        return repository.findAll().stream().map(i -> entityConverter.productToDto(i)).toList();
    }

    public List<ProductDto> searchProducts(String input) {
        return repository.findProductsByNameContainingOrDescriptionContaining(input, input)
                .stream().map(i -> entityConverter.productToDto(i)).toList();
    }

    public void deleteProduct(long productId) {
        repository.deleteById(productId);
    }
}
