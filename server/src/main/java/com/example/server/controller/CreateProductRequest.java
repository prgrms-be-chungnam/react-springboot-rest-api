package com.example.server.controller;

import com.example.server.model.Category;

public record CreateProductRequest(String productName, Category category,long price, String description) {
}
