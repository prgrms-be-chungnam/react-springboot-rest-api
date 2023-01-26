package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.example.gccoffee.JdbcUtils.*;

@Repository
public class ProductJdbcRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from products", productRowMapper);
    }

    @Override
    public Product insert(Product product) {
        var update = jdbcTemplate.update("INSERT INTO products(product_id, product_name, category, price, description, created_at, updated_at)" +
                " VALUES(UUID_TO_BIN(:productId) :productName :category :price :description :createdAt :updatedAt)", toParaMap(product));
//                " VALUES(UNHEX(REPLACE('77dea2ad-3c8c-40c6-a278-7cf1a1ac9384', '-', '')), ?, ?, ?, ?, ?, ?)", toParaMap(product));

        if (update != 1) {
            throw new RuntimeException("Nothing was inserted");
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String productName) {
        return Optional.empty();
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public void  deleteAll() {

    }

    private static final RowMapper<Product> productRowMapper = (rs, rowNum) -> {
        var productId = toUUID(rs.getBytes("product_id"));
        var productName = rs.getString("product_name");
        var category = Category.valueOf(rs.getString("category"));
        var price = rs.getLong("price");
        var description = rs.getString("description");
        var createdAt = toLocalDateTime(rs.getTimestamp("created_at"));
        var updatedAt = toLocalDateTime(rs.getTimestamp("updated_at"));
        return new Product(productId, productName, category, price, description, createdAt, updatedAt);
    };

    private Map<String, Object> toParaMap(Product product) {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("productId", product.getProductId().toString().getBytes());
        paramMap.put("productName", product.getProductName());
        paramMap.put("category", product.getCategory().toString());
        paramMap.put("price", product.getPrice());
        paramMap.put("description", product.getDescription());
        paramMap.put("createdAt", product.getCreatedAt());
        paramMap.put("updatedAt", product.getUpdatedAt());
        return paramMap;
    }
}
