package com.cnu.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderUpdateDto {
    private Long id;
    private List<Long> productIds;
    private OrderStatus orderStatus;
}
