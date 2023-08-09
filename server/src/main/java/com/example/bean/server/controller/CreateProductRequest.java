package com.example.bean.server.controller;

import com.example.bean.server.model.Category;

public record CreateProductRequest(String name, Category category, long price, String description) {

}
