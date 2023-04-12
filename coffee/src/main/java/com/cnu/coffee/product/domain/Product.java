package com.cnu.coffee.product.domain;

import com.cnu.coffee.order.Order;
import lombok.*;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@ToString
@Builder
@Entity(name = "products")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public Product(String productName, Category category, int price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.registeredDate = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.lastUpdatedDate = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
