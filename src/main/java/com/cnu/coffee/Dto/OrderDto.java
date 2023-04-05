package com.cnu.coffee.Dto;

import com.cnu.coffee.entity.OrderItem;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String email;
    private String address;
    private String postcode;
    private List<OrderItem> orderItems;
}
