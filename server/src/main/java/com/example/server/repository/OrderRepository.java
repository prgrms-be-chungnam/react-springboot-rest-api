package com.example.server.repository;

import com.example.server.model.Email;
import com.example.server.model.Order;

import java.util.List;

public interface OrderRepository {
    Order insert(Order order);

    List<Order> findByEmail(String email);

    List<Order> findAll();
}
