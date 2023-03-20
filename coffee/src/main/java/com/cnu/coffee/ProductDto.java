package com.cnu.coffee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private String origin;
    private String description;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .origin(origin)
                .description(description)
                .build();
    }
}
