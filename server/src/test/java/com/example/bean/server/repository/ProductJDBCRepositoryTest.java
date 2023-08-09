package com.example.bean.server.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class ProductJDBCRepositoryTest {

  private final Product testProduct = new Product(UUID.randomUUID(), "Sample Bean Package",
      Category.COFFEE_BEAN_PACKAGE, 10_000L);
  @Autowired
  private ProductJDBCRepository productRepository;

  @Test
  @Order(1)
  @DisplayName("Insert Product")
  public void testInsertProduct() {
    // Insert the test product into the database
    productRepository.insert(testProduct);

    // Retrieve the inserted product from the database
    Optional<Product> optionalProduct = productRepository.findByID(testProduct.getProductID());
    assertTrue(optionalProduct.isPresent());
    Product insertedProduct = optionalProduct.get();

    // Verify that the inserted product's data matches the expected values
    assertEquals(testProduct.getProductName(), insertedProduct.getProductName());
    assertEquals(testProduct.getCategory(), insertedProduct.getCategory());
    assertEquals(testProduct.getPrice(), insertedProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = insertedProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = insertedProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(2)
  @DisplayName("Update Product")
  public void testUpdateProduct() {
    // Update the test product's data
    testProduct.setProductName("Updated Bean Package");
    testProduct.setDescription("Updated Sample Bean Package");
    testProduct.setPrice(20_000L);
    productRepository.update(testProduct);

    // Retrieve the updated product from the database
    Optional<Product> optionalProduct = productRepository.findByID(testProduct.getProductID());
    assertTrue(optionalProduct.isPresent());
    Product updatedProduct = optionalProduct.get();

    // Verify that the updated product's data matches the expected values
    assertEquals(testProduct.getProductName(), updatedProduct.getProductName());
    assertEquals(testProduct.getCategory(), updatedProduct.getCategory());
    assertEquals(testProduct.getPrice(), updatedProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = updatedProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = updatedProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(3)
  @DisplayName("Find Product by ID")
  public void testFindById() {
    // Retrieve the test product by its ID from the database
    Optional<Product> optionalProduct = productRepository.findByID(testProduct.getProductID());
    assertTrue(optionalProduct.isPresent());
    Product foundProduct = optionalProduct.get();

    // Verify that the retrieved product's data matches the expected values
    assertEquals(testProduct.getProductName(), foundProduct.getProductName());
    assertEquals(testProduct.getCategory(), foundProduct.getCategory());
    assertEquals(testProduct.getPrice(), foundProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = foundProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = foundProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(4)
  @DisplayName("Find Product by Name")
  public void testFindByName() {
    // Retrieve the test product by its name from the database
    Optional<Product> optionalProduct = productRepository.findByName(testProduct.getProductName());
    assertTrue(optionalProduct.isPresent());
    Product foundProduct = optionalProduct.get();

    // Verify that the retrieved product's data matches the expected values
    assertEquals(testProduct.getProductName(), foundProduct.getProductName());
    assertEquals(testProduct.getCategory(), foundProduct.getCategory());
    assertEquals(testProduct.getPrice(), foundProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = foundProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = foundProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(5)
  @DisplayName("Find Products by Category")
  public void testFindByCategory() {
    // Retrieve products of the test category from the database
    List<Product> foundProducts = productRepository.findByCategory(testProduct.getCategory());
    assertEquals(1, foundProducts.size());
    Product foundProduct = foundProducts.stream()
        .filter(product -> product.getProductID().equals(testProduct.getProductID())).findFirst()
        .orElse(null);
    assertNotNull(foundProduct);

    // Verify that the retrieved product's data matches the expected values
    assertEquals(testProduct.getProductName(), foundProduct.getProductName());
    assertEquals(testProduct.getCategory(), foundProduct.getCategory());
    assertEquals(testProduct.getPrice(), foundProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = foundProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = foundProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(6)
  @DisplayName("Find All Products")
  public void testFindAll() {
    // Retrieve all products from the database
    List<Product> allProducts = productRepository.findAll();
    assertFalse(allProducts.isEmpty());
    Product foundProduct = allProducts.stream()
        .filter(product -> product.getProductID().equals(testProduct.getProductID())).findFirst()
        .orElse(null);
    assertNotNull(foundProduct);

    // Verify that the retrieved product's data matches the expected values
    assertEquals(testProduct.getProductName(), foundProduct.getProductName());
    assertEquals(testProduct.getCategory(), foundProduct.getCategory());
    assertEquals(testProduct.getPrice(), foundProduct.getPrice());

    // Compare LocalDateTime fields by formatting them as strings
    String expectedCreatedAtStr = testProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualCreatedAtStr = foundProduct.getCreatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedCreatedAtStr, actualCreatedAtStr);

    String expectedUpdatedAtStr = testProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    String actualUpdatedAtStr = foundProduct.getUpdatedAt()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS"));
    assertEquals(expectedUpdatedAtStr, actualUpdatedAtStr);
  }

  @Test
  @Order(7)
  @DisplayName("Delete Product by ID")
  public void testDeleteByID() {
    // Insert a test product and then delete it by its ID
    Optional<Product> optionalProduct = productRepository.findByID(testProduct.getProductID());
    assertTrue(optionalProduct.isPresent());

    // Delete the product by its ID and verify its deletion
    productRepository.deleteByID(testProduct.getProductID());
    optionalProduct = productRepository.findByID(testProduct.getProductID());
    assertFalse(optionalProduct.isPresent());
  }

  @Test
  @Order(8)
  @Disabled
  @DisplayName("Delete All Products")
  public void testDeleteAll() {
    // Delete all products from the database and verify that the table is empty
    productRepository.deleteAll();
    List<Product> products = productRepository.findAll();
    assertTrue(products.isEmpty());
  }
}
