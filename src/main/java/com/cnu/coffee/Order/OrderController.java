package com.cnu.coffee.Order;

import com.cnu.coffee.Dto.OrderDto;
import com.cnu.coffee.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/new-order")
    public Order setOrder(@RequestBody OrderDto orderDto){
        return service.setOrder(orderDto);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return service.getOrders();
    }
}
