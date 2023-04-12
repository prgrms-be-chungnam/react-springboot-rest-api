package com.cnu.coffee.product.domain;

import lombok.*;

import java.util.Optional;

@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String productName;
    private int price;
    private Category category;

    private Optional<String> description;

    public ProductRequestDto(String productName, Category category, int price){
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

}
