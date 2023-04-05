package com.cnu.coffee.Order;

import com.cnu.coffee.Dto.OrderDto;
import com.cnu.coffee.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderJpaRepository repository;

    public Order setOrder(OrderDto orderDto) {
        Order order = dtoToOrder(orderDto);
        Date now = new Date(System.currentTimeMillis());
        order.setCreatedDate(now);
        order.setUpdatedDate(now);
        return repository.save(order);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    private Order dtoToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setEmail(order.getEmail());
        order.setPostcode(orderDto.getPostcode());
        order.setAddress(orderDto.getAddress());
        order.setOrderItems(orderDto.getOrderItems());
        return order;
    }
}
