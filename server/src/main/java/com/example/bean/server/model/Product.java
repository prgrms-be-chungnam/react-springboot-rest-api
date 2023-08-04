package com.example.bean.server.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

/**
 * The {@code Product} class represents a product entity with its associated attributes, such as
 * product ID, name, category, price, description, creation timestamp, and last update timestamp. It
 * is intended to be used as a data model for products in an online store system where various types
 * of products need to be managed and stored.
 *
 * <p>This class provides methods for creating, accessing, and updating product information.
 * Additionally, it ensures that attributes are kept consistent with the following principles:
 * <ul>
 *   <li>{@code productID}, a unique identifier for the product, remains immutable once set.</li>
 *   <li>{@code createdAt} and {@code updatedAt} timestamps are automatically updated whenever any
 *       attribute of the product is modified.</li>
 *   <li>{@code productName}, {@code category}, {@code price}, and {@code description} are mutable
 *       and can be modified after the product is created.</li>
 *   <li>{@code productName}, {@code category}, {@code price}, and {@code description} can be set
 *       individually using dedicated setter methods, which ensure proper timestamp updates.</li>
 * </ul>
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Getter
public class Product {

  private final UUID productID;
  private final LocalDateTime createdAt;
  private String productName;
  private Category category;
  private long price;
  private String description;
  private LocalDateTime updatedAt;

  /**
   * Constructs a new product with the specified parameters, setting the {@code createdAt} and
   * {@code updatedAt} timestamps to the current date and time.
   *
   * @param productID   The unique identifier for the product.
   * @param productName The name of the product.
   * @param category    The category of the product.
   * @param price       The price of the product in the smallest unit of currency (e.g., cents).
   */
  public Product(UUID productID, String productName, Category category, long price) {
    this(productID, productName, category, price, "", LocalDateTime.now(), LocalDateTime.now());
  }

  /**
   * Constructs a new product with the specified parameters.
   *
   * @param productID   The unique identifier for the product.
   * @param productName The name of the product.
   * @param category    The category of the product.
   * @param price       The price of the product in the smallest unit of currency (e.g., cents).
   * @param description A brief description of the product.
   * @param createdAt   The timestamp when the product was created.
   * @param updatedAt   The timestamp when the product was last updated.
   */
  public Product(UUID productID, String productName, Category category, long price,
      String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.productID = productID;
    this.productName = productName;
    this.category = category;
    this.price = price;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  /**
   * Sets the name of the product and updates the {@code updatedAt} timestamp.
   *
   * @param productName The new name of the product.
   */
  public void setProductName(String productName) {
    this.productName = productName;
    update();
  }

  /**
   * Sets the category of the product and updates the {@code updatedAt} timestamp.
   *
   * @param category The new category of the product.
   */
  public void setCategory(Category category) {
    this.category = category;
    update();
  }

  /**
   * Sets the price of the product and updates the {@code updatedAt} timestamp.
   *
   * @param price The new price of the product in the smallest unit of currency (e.g., cents).
   */
  public void setPrice(long price) {
    this.price = price;
    update();
  }

  /**
   * Sets the description of the product and updates the {@code updatedAt} timestamp.
   *
   * @param description The new description of the product.
   */
  public void setDescription(String description) {
    this.description = description;
    update();
  }

  /**
   * Updates the {@code updatedAt} timestamp to the current date and time. This method is called
   * internally whenever any attribute of the product is modified.
   */
  private void update() {
    this.updatedAt = LocalDateTime.now();
  }
}
