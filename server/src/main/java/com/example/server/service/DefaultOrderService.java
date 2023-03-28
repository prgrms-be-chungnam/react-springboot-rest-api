package com.example.server.service;

import com.example.server.model.Email;
import com.example.server.model.Order;
import com.example.server.model.OrderItem;
import com.example.server.model.OrderStatus;
import com.example.server.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(String email, String address, String postcode, List<OrderItem> orderItems) {
        Order order = new Order(
                UUID.randomUUID(),
                email,
                address,
                postcode,
                orderItems,
                OrderStatus.ACCEPTED,
                LocalDateTime.now(),
                LocalDateTime.now());
        return orderRepository.insert(order);
    }

    @Override
    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findByEmail(email);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
