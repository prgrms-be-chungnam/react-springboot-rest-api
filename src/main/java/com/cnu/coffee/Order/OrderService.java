package com.cnu.coffee.Order;

import com.cnu.coffee.EntityConverter;
import com.cnu.coffee.Dto.OrderDto;
import com.cnu.coffee.entity.Order;
import com.cnu.coffee.entity.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderJpaRepository repository;
    @Autowired
    OrderItemJpaRepository orderItemRepository;

    @Autowired
    EntityConverter entityConverter;

    public Order setOrder(OrderDto orderDto) {
        Order order = entityConverter.dtoToOrder(orderDto);
        Date now = new Date(System.currentTimeMillis());
        order.setOrderStatus(OrderStatus.ACCEPTED);
        order.setCreatedDate(now);
        order.setUpdatedDate(now);
        Order save = repository.save(order);
        orderItemRepository.saveAll(order.getOrderItems());
        return save;
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }


}
