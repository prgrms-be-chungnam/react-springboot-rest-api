package com.cnu.coffee.order;

import com.cnu.coffee.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "order_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime orderTime;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedTime;

    @OneToMany(mappedBy = "order")
    @Column(name = "products", nullable = false)
    private List<Product> products;

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
