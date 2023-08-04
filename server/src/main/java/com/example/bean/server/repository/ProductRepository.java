package com.example.bean.server.repository;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@code ProductRepository} interface defines the contract for accessing and managing product
 * data in the database. Implementations of this interface provide the necessary operations to
 * perform CRUD (Create, Read, Update, Delete) operations on product entities.
 *
 * @version 1.1
 * @since 2023-08-04
 */
public interface ProductRepository {

  /**
   * Retrieves all products from the database.
   *
   * @return A list of all products stored in the database.
   */
  List<Product> findAll();

  /**
   * Inserts a new product into the database.
   *
   * @param product The product to be inserted.
   * @return The inserted product with any auto-generated values set (e.g., product ID).
   */
  Product insert(Product product);

  /**
   * Updates an existing product in the database.
   *
   * @param product The product to be updated.
   * @return The updated product.
   */
  Product update(Product product);

  /**
   * Finds a product by its unique identifier (product ID) in the database.
   *
   * @param productID The unique identifier of the product to find.
   * @return An optional containing the found product, or empty if not found.
   */
  Optional<Product> findByID(UUID productID);

  /**
   * Finds a product by its name in the database.
   *
   * @param productName The name of the product to find.
   * @return An optional containing the found product, or empty if not found.
   */
  Optional<Product> findByName(String productName);

  /**
   * Finds all products belonging to a specific category in the database.
   *
   * @param category The category of products to find.
   * @return A list of products belonging to the specified category.
   */
  List<Product> findByCategory(Category category);

  /**
   * Deletes a product from the database based on its unique identifier (product ID).
   *
   * @param productID The unique identifier of the product to delete.
   */
  void deleteByID(UUID productID);

  /**
   * Deletes all products from the database. Use with caution as it removes all product data.
   */
  void deleteAll();
}
