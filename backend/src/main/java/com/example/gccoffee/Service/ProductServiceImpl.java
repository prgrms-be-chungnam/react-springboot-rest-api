package com.example.gccoffee.Service;

import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Optional<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    @Transactional
    public UUID save(Product product) {
        log.info("Product saved with \n ID => {} \n Name => {} \n Category => {} \n price => {} \n quantity => {}",
                product.getProductId(), product.getProductName(), product.getCategory(), product.getPrice(), product.getQuantity());
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    @Transactional
    public Product cancel(Product product) {
        return null;
    }

    @Override
    @Transactional
    public Product update(Product target, String name, long price, int quantity, String description) {
        return productRepository.save(
                target.builder()
                .dto(ProductDTO.builder()
                                .id(target.getProductId())
                                .name(name)
                                .price(price)
                                .quantity(quantity)
                                .category(target.getCategory())
                                .description(description)
                                .build()
                ).build());

    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<Product> product =  productRepository.findById(id);
        if (product.isEmpty()) {
            throw new NoSuchProductException("상품이 존재하지 않습니다.");
        }else{
            return product;
        }
    }

    @Override
    @Transactional
    public String delete(UUID id) {
        Optional<Product> target = productRepository.findById(id);
        productRepository.delete(target.get());
        return target.get().toString();

    }

    @Override
    public List<Product> findByCategory(Category category) {

        List<Product> found = productRepository.findByCategory(category);
        return found;
    }


}
