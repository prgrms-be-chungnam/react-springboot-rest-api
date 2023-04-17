package com.cnu.coffee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String email;
    private String address;
    private String postcode;
    private List<OrderItemDto> orderItemDtos;
}
