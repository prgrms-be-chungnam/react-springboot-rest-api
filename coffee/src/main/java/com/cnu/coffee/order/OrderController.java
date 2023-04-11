package com.cnu.coffee.order;

import com.cnu.coffee.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public OrderDto addOrder(@RequestBody List<Product> products){
        return orderService.save(products);
    }

    @GetMapping("/{id}")
    public OrderDto findOrder(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @GetMapping("/page")
    public Page<OrderDto> findAllOrder(Pageable pageable){
        return orderService.findAll(pageable);
    }

    @PutMapping("")
    public OrderDto modifyOrder(@RequestBody OrderDto orderDto){
        return orderService.update(orderDto);
    }

    @DeleteMapping("/{id}")
    public void removeOrder(@PathVariable("id") Long id){
        orderService.deleteById(id);
    }
}
