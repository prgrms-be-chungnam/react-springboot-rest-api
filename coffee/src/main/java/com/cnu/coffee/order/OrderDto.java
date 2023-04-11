package com.cnu.coffee.order;

import com.cnu.coffee.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private int totalPrice;
    private LocalDateTime orderTime;
    private LocalDateTime updatedTime;
    private List<Product> products;

}
