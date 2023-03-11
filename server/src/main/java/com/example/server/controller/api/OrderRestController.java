package com.example.server.controller.api;

import com.example.server.controller.CreateOrderRequest;
import com.example.server.model.Email;
import com.example.server.model.Order;
import com.example.server.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        return orderService.createOrder(
                orderRequest.email(),
                orderRequest.address(),
                orderRequest.postcode(),
                orderRequest.orderItems()
        );
    }
    @GetMapping("/api/v1/order")
    public List<Order> searchItem(@RequestParam Optional<String> email) {
        return email
                .map(orderService::getOrdersByEmail)
                .orElse(orderService.getAllOrders());
    }
}
