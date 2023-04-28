package com.cnu.coffee.Order;

import com.cnu.coffee.EntityConverter;
import com.cnu.coffee.Dto.OrderDto;
import com.cnu.coffee.Product.ProductJpaRepository;
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
    ProductJpaRepository productRepository;
    @Autowired
    EntityConverter entityConverter;

    public OrderDto setOrder(OrderDto orderDto) {
        Order order = entityConverter.dtoToOrder(orderDto);
        Date now = new Date(System.currentTimeMillis());
        order.setOrderStatus(OrderStatus.ACCEPTED);
        order.setCreatedDate(now);
        order.setUpdatedDate(now);
        order.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(order);
            orderItem.setProduct(productRepository.getReferenceById(orderItem.getProduct().getId()));
            orderItem.setPrice(orderItem.getProduct().getPrice()*orderItem.getQuantity());
        } );
        Order save = repository.save(order);
        return entityConverter.orderToDto(save);
    }

    public List<OrderDto> getOrders() {
        return repository.findAll().stream().map(i -> entityConverter.orderToDto(i)).toList();
    }

    public void deleteOrder(long orderId) {
        repository.deleteById(orderId);
    }
}
