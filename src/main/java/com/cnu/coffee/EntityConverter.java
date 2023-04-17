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
        order.setId(orderDto.getId());
        order.setEmail(orderDto.getEmail());
        order.setAddress(orderDto.getAddress());
        order.setPostcode(orderDto.getPostcode());
        order.setOrderItems(orderDto.getOrderItemDtos().stream().map(this::dtoToOrderItem).toList());
        return order;
    }

    public OrderItem dtoToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
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

    public OrderDto orderToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .email(order.getEmail())
                .address(order.getAddress())
                .postcode(order.getPostcode())
                .orderItemDtos(order.getOrderItems().stream().map(this::orderItemToDto).toList())
                .build();
    }

    public OrderItemDto orderItemToDto(OrderItem orderItem) {
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .productDto(productToDto(orderItem.getProduct()))
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .build();
    }

    public ProductDto productToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
