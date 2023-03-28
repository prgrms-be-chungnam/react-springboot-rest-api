package com.example.server.service;

import com.example.server.model.Email;
import com.example.server.model.Order;
import com.example.server.model.OrderItem;

import java.util.List;

public interface OrderService {

    Order createOrder(String email, String address, String postcode, List<OrderItem> orderItems);

    List<Order> getOrdersByEmail(String email);
    List<Order> getAllOrders();
}
