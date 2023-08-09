package com.example.bean.server.controller;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import com.example.bean.server.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code ProductRestController} class is a Spring MVC controller that provides a RESTful API
 * for retrieving product information.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@RestController
public class ProductRestController {

  private final ProductService productService;

  /**
   * Constructs a new {@code ProductRestController} with the given {@link ProductService}.
   *
   * @param productService The ProductService to be used for product-related operations.
   */
  public ProductRestController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Handles the HTTP GET request to retrieve a list of products based on the specified category. If
   * no category is provided, all products are returned.
   *
   * @param category The optional product category to filter the results.
   * @return A list of products based on the specified category or all products if no category is
   * provided.
   */
  @GetMapping("/api/v1/products")
  public List<Product> productList(@RequestParam Optional<Category> category) {
    return category.map(productService::getProductsByCategory)
        .orElse(productService.getAllProducts());
  }
}