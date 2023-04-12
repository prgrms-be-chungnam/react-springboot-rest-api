package com.cnu.coffee.order;

import com.cnu.coffee.exeption.OrderNotFoundException;
import com.cnu.coffee.exeption.ProductNotFoundException;
import com.cnu.coffee.product.domain.Product;
import com.cnu.coffee.product.repository.ProductJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductJpaRepository productRepository;

    public List<Product> getProductList(List<Long> productIds){
        List<Product> productList = new ArrayList<>();
        productIds.stream().map(
                id -> productRepository.findById(id).orElseThrow(
                        () -> new ProductNotFoundException("상품을 찾을 수 없습니다")
                )
        ).forEach(
                p -> productList.add(p)
        );
        return productList;
    }

    public List<Long> getProductIds(List<Product> products){
        List<Long> productIds = new ArrayList<>();
        products.stream().map(
                p -> p.getId()
        ).forEach(
                id -> productIds.add(id)
        );
        return productIds;
    }

    public OrderDto create(List<Long> productIds) {
        List<Product> productList = getProductList(productIds);
        Order order = Order.builder()
                .products(productList)
                .totalPrice(Order.countTotalPrice(productList))
                .orderStatus(OrderStatus.PAYMENT_REQUESTED)
                .orderTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(saved, dto);

        dto.setProductIds(productIds);
        return dto;
    }

    public OrderDto findById(Long id) {
        Order found = orderRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException(id + "에 해당하는 주문이 없습니다")
        );
        log.info("found -> {}", found);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(found, dto);

        dto.setProductIds(getProductIds(found.getProducts()));
        return dto;
    }

    public List<OrderDto> findAll() {
        List<OrderDto> dtoList = new ArrayList<>();
        orderRepository.findAll().stream().map(
                order -> {
                    OrderDto dto = new OrderDto();
                    BeanUtils.copyProperties(order, dto);

                    dto.setProductIds(getProductIds(order.getProducts()));
                    return dto;
                }
        ).forEach(o -> dtoList.add(o));
        return dtoList;
    }

    public Page<OrderDto> findOrderPage(Pageable pageable) {
        return orderRepository.findAll(pageable).map(
                order -> {
                    OrderDto dto = new OrderDto();
                    BeanUtils.copyProperties(order, dto);

                    dto.setProductIds(getProductIds(order.getProducts()));
                    return dto;
                }
        );
    }

    public OrderDto update(OrderUpdateDto orderUpdateDto) {
        List<Product> productList = getProductList(orderUpdateDto.getProductIds());

        Order found = orderRepository.findById(orderUpdateDto.getId()).orElseThrow(
                () -> new OrderNotFoundException("주문번호(" + orderUpdateDto.getId() + ")에 해당하는 주문이 없습니다")
        );
        Order order = Order.builder()
                .id(orderUpdateDto.getId())
                .products(productList)
                .totalPrice(Order.countTotalPrice(productList))
                .orderStatus(orderUpdateDto.getOrderStatus())
                .orderTime(found.getOrderTime())
                .updatedTime(LocalDateTime.now())
                .build();
        Order saved = orderRepository.save(order);

        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(saved, dto);

        dto.setProductIds(getProductIds(saved.getProducts()));
        return dto;
    }

    public OrderDto updateStatus(OrderIdStautsDto orderIdStautsDto) {
        Order found = orderRepository.findById(orderIdStautsDto.getId()).orElseThrow(
                () -> new OrderNotFoundException("주문번호(" + orderIdStautsDto.getId() + ")에 해당하는 주문이 없습니다")
        );
        Order order = Order.builder()
                .id(orderIdStautsDto.getId())
                .products(found.getProducts())
                .totalPrice(Order.countTotalPrice(found.getProducts()))
                .orderStatus(orderIdStautsDto.getOrderStatus())
                .orderTime(found.getOrderTime())
                .updatedTime(LocalDateTime.now())
                .build();

        Order saved = orderRepository.save(order);

        log.info("saved -> {}", saved);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(saved, dto);

        dto.setProductIds(getProductIds(saved.getProducts()));
        return dto;
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }


}
