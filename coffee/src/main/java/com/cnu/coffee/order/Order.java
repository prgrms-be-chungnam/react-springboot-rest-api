package com.cnu.coffee.order;

import com.cnu.coffee.product.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Builder
@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

    @Column(name = "total_price")
    private int totalPrice;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column(name = "order_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime orderTime;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedTime;

    public void addProduct(Product product){
        this.products.add(product);
    }

    public static int countTotalPrice(List<Product> products){
        int total = 0;
        for (Product product : products){
            total += product.getPrice();
        }
        return total;
    }
}
