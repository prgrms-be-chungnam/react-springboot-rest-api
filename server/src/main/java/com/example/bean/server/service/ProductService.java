package com.example.bean.server.service;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import java.util.List;

/**
 * The {@code ProductService} interface defines the contract for managing product-related
 * operations. Implementations of this interface provide methods to interact with products, such as
 * retrieving products by category, creating new products, and retrieving all products.
 *
 * @version 1.0
 * @since 2023-08-04
 */
public interface ProductService {

  /**
   * Retrieves a list of products that belong to the specified category.
   *
   * @param category The category for which to retrieve products.
   * @return A list of products that belong to the specified category.
   */
  List<Product> getProductsByCategory(Category category);

  /**
   * Retrieves a list of all products stored in the system.
   *
   * @return A list of all products stored in the system.
   */
  List<Product> getAllProducts();

  /**
   * Creates a new product with the given name, category, and price.
   *
   * @param productName The name of the new product.
   * @param category    The category of the new product.
   * @param price       The price of the new product.
   * @return The created product.
   */
  Product createProduct(String productName, Category category, long price);

  /**
   * Creates a new product with the given name, category, price, and description.
   *
   * @param productName The name of the new product.
   * @param category    The category of the new product.
   * @param price       The price of the new product.
   * @param description The description of the new product.
   * @return The created product.
   */
  Product createProduct(String productName, Category category, long price, String description);
}
