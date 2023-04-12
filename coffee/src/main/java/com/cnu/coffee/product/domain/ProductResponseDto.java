package com.cnu.coffee.product.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String productName;

    private Category category;

    private Optional<String> description;

    private int price;

    private LocalDateTime registeredDate;

    private LocalDateTime lastUpdatedDate;

}
