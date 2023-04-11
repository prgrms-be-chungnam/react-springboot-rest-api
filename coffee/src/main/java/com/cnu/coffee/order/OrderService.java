package com.cnu.coffee.order;

import com.cnu.coffee.exeption.OrderNotFoundException;
import com.cnu.coffee.product.domain.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDto save(List<Product> products) {
        Order order = Order.builder()
                .products(products)
                .totalPrice(Order.countTotalPrice(products))
                .orderTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    public OrderDto findById(Long id) {
        Order found = orderRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException(id + "에 해당하는 주문이 없습니다")
        );
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(found, dto);
        return dto;
    }

    public OrderDto update(OrderDto orderDto) {
        Order order = Order.builder()
                .id(orderDto.getId())
                .products(orderDto.getProducts())
                .totalPrice(Order.countTotalPrice(orderDto.getProducts()))
                .updatedTime(LocalDateTime.now())
                .build();
        Order saved = orderRepository.save(order);

        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Page<OrderDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).map(
                order -> {
                    OrderDto dto = new OrderDto();
                    BeanUtils.copyProperties(order, dto);
                    return dto;
                }
        );
    }
}
