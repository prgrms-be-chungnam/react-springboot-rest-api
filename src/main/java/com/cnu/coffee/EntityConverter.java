package com.cnu.coffee;

import com.cnu.coffee.Dto.OrderDto;
import com.cnu.coffee.Dto.OrderItemDto;
import com.cnu.coffee.Dto.ProductDto;
import com.cnu.coffee.entity.Order;
import com.cnu.coffee.entity.OrderItem;
import com.cnu.coffee.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {
    public Order dtoToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setEmail(orderDto.getEmail());
        order.setPostcode(orderDto.getPostcode());
        order.setAddress(orderDto.getAddress());
        order.setOrderItems(orderDto.getOrderItemDtos().stream().map(dto -> dtoToOrderItem(dto, order)).toList());
        return order;
    }

    public OrderItem dtoToOrderItem(OrderItemDto orderItemDto, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(dtoToProduct(orderItemDto.getProductDto()));
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItem.getProduct().getPrice() * orderItem.getQuantity());
        return orderItem;
    }

    public Product dtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }
}
