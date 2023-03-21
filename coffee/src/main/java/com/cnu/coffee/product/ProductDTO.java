package com.cnu.coffee.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private int price;
    private Category category;
    private String description;

}
