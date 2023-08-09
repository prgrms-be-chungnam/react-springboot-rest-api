package com.example.bean.server.controller;

import com.example.bean.server.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The {@code ProductController} class is a Spring MVC controller that handles HTTP requests related
 * to product management and serves as an entry point for user interactions with products.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Controller
public class ProductController {

  private final ProductService productService;

  /**
   * Constructs a new {@code ProductController} with the given {@link ProductService}.
   *
   * @param productService The ProductService to be used for product-related operations.
   */
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Handles the HTTP GET request to display the products page.
   *
   * @param model The Model to which the list of products will be added.
   * @return The logical view name "product-list" to render the products page.
   */
  @GetMapping("/products")
  public String productsPage(Model model) {
    var products = productService.getAllProducts();
    model.addAttribute("products", products);
    return "product-list";
  }

  /**
   * Handles the HTTP GET request to display the new product creation page.
   *
   * @return The logical view name "new-product" to render the new product creation page.
   */
  @GetMapping("/new-product")
  public String newProductPage() {
    return "new-product";
  }

  /**
   * Handles the HTTP POST request to create a new product.
   *
   * @param createProductRequest The request object containing details of the new product.
   * @return A redirect to the products page after successful product creation.
   */
  @PostMapping("/products")
  public String newProduct(CreateProductRequest createProductRequest) {
    productService.createProduct(createProductRequest.name(), createProductRequest.category(),
        createProductRequest.price(), createProductRequest.description());
    return "redirect:/products";
  }
}