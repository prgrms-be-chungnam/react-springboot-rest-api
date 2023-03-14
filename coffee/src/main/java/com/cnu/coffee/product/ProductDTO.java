package com.cnu.coffee.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private int price;
    private Category category;

}
