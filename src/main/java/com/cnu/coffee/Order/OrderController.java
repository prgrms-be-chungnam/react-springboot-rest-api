package com.cnu.coffee.Order;

import com.cnu.coffee.Dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/new-order")
    public OrderDto setOrder(@RequestBody OrderDto orderDto){
        return service.setOrder(orderDto);
    }

    @GetMapping("/orders")
    public List<OrderDto> getOrders(){
        return service.getOrders();
    }

    @DeleteMapping("/delete-order")
    public void deleteOrder(@RequestParam("id") long orderId){
        service.deleteOrder(orderId);
    }
}
