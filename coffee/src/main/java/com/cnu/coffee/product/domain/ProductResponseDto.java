package com.cnu.coffee.product.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private UUID id;

    private String productName;

    private Category category;

    private Optional<String> description = Optional.empty();

    private int price;

    private LocalDateTime registeredDate;

    private LocalDateTime lastUpdatedDate;

    public ProductResponseDto(UUID id, String productName, Category category, int price, LocalDateTime registeredDate, LocalDateTime lastUpdatedDate) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.registeredDate = registeredDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
