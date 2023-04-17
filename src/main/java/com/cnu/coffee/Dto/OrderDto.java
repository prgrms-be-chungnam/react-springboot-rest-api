package com.cnu.coffee.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;
    private String email;
    private String address;
    private String postcode;
    private List<OrderItemDto> orderItemDtos;
}
