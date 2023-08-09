package com.example.bean.server.service;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import com.example.bean.server.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * The {@code DefaultProductService} class is an implementation of the {@link ProductService}
 * interface that provides methods for managing product-related operations. It interacts with the
 * {@link ProductRepository} to perform CRUD (Create, Read, Update, Delete) operations on product
 * entities.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Service
public class DefaultProductService implements ProductService {

  private final ProductRepository productRepository;

  /**
   * Constructs a new {@code DefaultProductService} with the specified {@link ProductRepository}.
   *
   * @param productRepository The repository to be used for interacting with product data.
   */
  public DefaultProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getProductsByCategory(Category category) {
    return productRepository.findByCategory(category);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product createProduct(String productName, Category category, long price) {
    var product = new Product(UUID.randomUUID(), productName, category, price);
    return productRepository.insert(product);
  }

  @Override
  public Product createProduct(String productName, Category category, long price,
      String description) {
    var product = new Product(UUID.randomUUID(), productName, category, price, description,
        LocalDateTime.now(), LocalDateTime.now());
    return productRepository.insert(product);
  }
}
