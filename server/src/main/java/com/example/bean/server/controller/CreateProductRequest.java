package com.example.bean.server.controller;

import com.example.bean.server.model.Category;

/**
 * The {@code CreateProductRequest} record represents a request to create a new product. It
 * encapsulates the necessary information for creating a product, including its name, category,
 * price, and description.
 *
 * @version 1.0
 * @since 2023-08-04
 */
public record CreateProductRequest(String name, Category category, long price, String description) {

}
