package com.example.bean.server.repository;

import static com.example.bean.server.JDBCUtils.toLocalDateTime;
import static com.example.bean.server.JDBCUtils.toUUID;

import com.example.bean.server.model.Category;
import com.example.bean.server.model.Product;
import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

/**
 * The {@code ProductJDBCRepository} class is an implementation of the {@link ProductRepository}
 * interface that interacts with a database using JDBC. It provides methods to perform CRUD (Create,
 * Read, Update, Delete) operations on product entities in the database.
 *
 * @version 1.1
 * @since 2023-08-04
 */
@Repository
public class ProductJDBCRepository implements ProductRepository {

  private static final RowMapper<Product> productRowMapper = ProductJDBCRepository::mapProductRow;
  private final NamedParameterJdbcTemplate namedJDBCTemplate;
  private final JdbcTemplate jdbcTemplate;

  /**
   * Constructs a new {@code ProductJDBCRepository} with the given NamedParameterJdbcTemplate.
   *
   * @param namedJDBCTemplate The NamedParameterJdbcTemplate to be used for database operations.
   */
  public ProductJDBCRepository(NamedParameterJdbcTemplate namedJDBCTemplate) {
    this.namedJDBCTemplate = namedJDBCTemplate;
    this.jdbcTemplate = new JdbcTemplate(
        Objects.requireNonNull(this.namedJDBCTemplate.getJdbcTemplate().getDataSource()));
  }

  /**
   * Maps a database result set to a {@link Product} object.
   *
   * @param resultSet The result set containing the product data from the database.
   * @param rowNum    The current row number (not used in this implementation).
   * @return The {@link Product} object representing the data in the result set.
   * @throws SQLException If there is an error accessing the result set.
   */
  private static Product mapProductRow(ResultSet resultSet, int rowNum) throws SQLException {
    var productID = toUUID(resultSet.getBytes("PRODUCT_ID"));
    var productName = resultSet.getString("PRODUCT_NAME");
    var category = Category.valueOf(resultSet.getString("CATEGORY"));
    var price = resultSet.getLong("PRICE");
    var description = resultSet.getString("DESCRIPTION");
    var createdAt = toLocalDateTime(resultSet.getTimestamp("CREATED_AT"));
    var updatedAt = toLocalDateTime(resultSet.getTimestamp("UPDATED_AT"));
    return new Product(productID, productName, category, price, description, createdAt, updatedAt);
  }

  /**
   * Converts a {@link Product} object to a parameter map for database operations.
   *
   * @param product The {@link Product} object to be converted to a parameter map.
   * @return A {@link Map} containing parameter names and their corresponding values from the
   * product object.
   */
  private Map<String, Object> toParamMap(Product product) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("productID", product.getProductID().toString().getBytes());
    paramMap.put("productName", product.getProductName());
    paramMap.put("category", product.getCategory().toString());
    paramMap.put("price", product.getPrice());
    paramMap.put("description", product.getDescription());
    paramMap.put("createdAt", product.getCreatedAt());
    paramMap.put("updatedAt", product.getUpdatedAt());
    return paramMap;
  }

  /**
   * Initializes the database schema by checking if the 'PRODUCTS' table exists. If the table does
   * not exist, it creates the table using the 'createProductsTable' method.
   */
  @PostConstruct
  public void initializeDatabaseSchema() {
    if (!isProductsTableExist()) {
      createProductsTable();
    }
  }

  /**
   * Creates the 'PRODUCTS' table in the database by executing the SQL script defined in the
   * 'scheme.sql' file. The method reads the 'scheme.sql' file from the classpath and executes its
   * contents as a SQL query using the JdbcTemplate. If the table already exists, this method will
   * not make any changes to the database.
   *
   * <p>This method is intended to be used during the initialization of the database schema. If an
   * error occurs during the creation of the table or while reading the 'scheme.sql' file, a
   * RuntimeException will be thrown with a descriptive error message indicating the cause of the
   * failure.
   *
   * <p>Note: The 'scheme.sql' file should contain the SQL script necessary to create the
   * 'PRODUCTS' table with the appropriate columns and constraints.
   *
   * @throws RuntimeException if an error occurs while creating the 'PRODUCTS' table or reading the
   *                          'scheme.sql' file.
   * @see org.springframework.jdbc.core.JdbcTemplate#execute(String)
   */
  private void createProductsTable() {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new ClassPathResource("scheme.sql").getInputStream(),
            StandardCharsets.UTF_8))) {
      jdbcTemplate.execute(FileCopyUtils.copyToString(reader));
    } catch (IOException | DataAccessException e) {
      throw new RuntimeException("Error creating 'PRODUCTS' table.", e);
    }
  }

  /**
   * Check if the 'PRODUCTS' table exists in the database.
   *
   * @return true if the table exists, false otherwise.
   */
  public boolean isProductsTableExist() {
    String query = "SELECT COUNT(*) FROM information_schema.TABLES WHERE TABLE_NAME = 'PRODUCTS'";
    try {
      Integer result = jdbcTemplate.queryForObject(query, Integer.class);
      return result != null && result > 0;
    } catch (DataAccessException e) {
      return false;
    }
  }

  @Override
  public List<Product> findAll() {
    return namedJDBCTemplate.query("SELECT * FROM PRODUCTS", productRowMapper);
  }

  @Override
  public Product insert(Product product) {
    var update = namedJDBCTemplate.update(
        "INSERT INTO PRODUCTS(PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE, DESCRIPTION, CREATED_AT, UPDATED_AT) VALUES(UNHEX(REPLACE(:productID, '-', '')), :productName, :category, :price, :description, :createdAt, :updatedAt)",
        toParamMap(product));
    if (update != 1) {
      throw new RuntimeException("Nothing was inserted");
    }
    return product;
  }

  @Override
  public Product update(Product product) {
    var update = namedJDBCTemplate.update(
        "UPDATE PRODUCTS SET PRODUCT_NAME = :productName, CATEGORY = :category, PRICE = :price, DESCRIPTION = :description, CREATED_AT = :createdAt, UPDATED_AT = :updatedAt WHERE PRODUCT_ID = UNHEX(REPLACE(:productID, '-', ''))",
        toParamMap(product));
    if (update != 1) {
      throw new RuntimeException("Nothing was updated");
    }
    return product;
  }

  @Override
  public Optional<Product> findByID(UUID productID) {
    try {
      return Optional.ofNullable(namedJDBCTemplate.queryForObject(
          "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = UNHEX(REPLACE(:productID, '-', ''))",
          Collections.singletonMap("productID", productID.toString().getBytes()),
          productRowMapper));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Product> findByName(String productName) {
    try {
      return Optional.ofNullable(namedJDBCTemplate.queryForObject(
          "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = :productName",
          Collections.singletonMap("productName", productName), productRowMapper));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public List<Product> findByCategory(Category category) {
    return namedJDBCTemplate.query("SELECT * FROM PRODUCTS WHERE CATEGORY = :category",
        Collections.singletonMap("category", category.toString()), productRowMapper);
  }

  @Override
  public void deleteByID(UUID productID) {
    namedJDBCTemplate.update(
        "DELETE FROM PRODUCTS WHERE PRODUCT_ID = UNHEX(REPLACE(:productID, '-', ''))",
        Collections.singletonMap("productID", productID.toString().getBytes()));
  }

  @Override
  public void deleteAll() {
    jdbcTemplate.update("TRUNCATE PRODUCTS");
  }
}
