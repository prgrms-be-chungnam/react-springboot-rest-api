package com.example.bean.server.model;

import java.util.UUID;

/**
 * The {@code OrderItem} record represents an item within an order in an online store system. Each
 * order item is associated with a product, its category, price, and quantity. It is used to store
 * the details of a specific product included in an order.
 *
 * @version 1.0
 * @since 2023-08-04
 */
public record OrderItem(UUID productId, Category category, long price, int quantity) {

}
