package com.cnu.coffee.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderIdStautsDto {
    private Long id;
    private OrderStatus orderStatus;
}
