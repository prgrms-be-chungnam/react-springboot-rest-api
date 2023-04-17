package com.cnu.coffee.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private long id;
    //private OrderDto orderDto;
    private ProductDto productDto;
    private int quantity;
    private int price;
}
