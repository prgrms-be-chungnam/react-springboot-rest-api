package com.cnu.coffee.product;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /*
     * Input: String name, int price
     * */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "product_name", nullable = false, length = 30)
    private String productName;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "registered_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime registeredDate;
    @Column(name = "last_updated_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdatedDate;

    public Product(UUID id, String productName, Category category, int price) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.registeredDate = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.lastUpdatedDate = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
