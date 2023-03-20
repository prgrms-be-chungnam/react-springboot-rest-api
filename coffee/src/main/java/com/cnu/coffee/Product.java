package com.cnu.coffee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "description", nullable = false)
    private String description;

    public ProductDto toDto() {
        return ProductDto.builder()
                .id(id)
                .name(name)
                .origin(origin)
                .description(description)
                .build();
    }
}
