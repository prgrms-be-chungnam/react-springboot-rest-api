package com.example.bean.server.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

/**
 * The {@code Order} class represents an order placed by a customer in an online store. It contains
 * information about the order, such as order ID, customer email, delivery address, postal code,
 * ordered items, order status, creation timestamp, and last update timestamp.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Getter
public class Order {

  private final UUID orderID;
  private final Mail email;
  private final List<OrderItem> orderItems;
  private final LocalDateTime createdAt;
  private String address;
  private String postcode;
  private OrderStatus orderStatus;
  private LocalDateTime updatedAt;

  /**
   * Constructs a new order with the specified parameters, setting the createdAt and updatedAt
   * timestamps to the current date and time.
   *
   * @param orderID     The unique identifier for the order.
   * @param email       The customer's email associated with the order.
   * @param address     The delivery address for the order.
   * @param postcode    The postal code of the delivery address.
   * @param orderItems  The list of items included in the order.
   * @param orderStatus The current status of the order.
   */
  public Order(UUID orderID, Mail email, String address, String postcode,
      List<OrderItem> orderItems, OrderStatus orderStatus) {
    this(orderID, email, address, postcode, orderItems, orderStatus, LocalDateTime.now(),
        LocalDateTime.now());
  }

  /**
   * Constructs a new order with the specified parameters.
   *
   * @param orderID     The unique identifier for the order.
   * @param email       The customer's email associated with the order.
   * @param address     The delivery address for the order.
   * @param postcode    The postal code of the delivery address.
   * @param orderItems  The list of items included in the order.
   * @param orderStatus The current status of the order.
   * @param createdAt   The timestamp when the order was created.
   * @param updatedAt   The timestamp when the order was last updated.
   */
  public Order(UUID orderID, Mail email, String address, String postcode,
      List<OrderItem> orderItems, OrderStatus orderStatus, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.orderID = orderID;
    this.email = email;
    this.address = address;
    this.postcode = postcode;
    this.orderItems = orderItems;
    this.orderStatus = orderStatus;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  /**
   * Sets the delivery address for the order and updates the updatedAt timestamp.
   *
   * @param address The new delivery address.
   */
  public void setAddress(String address) {
    this.address = address;
    update();
  }

  /**
   * Sets the postal code of the delivery address for the order and updates the updatedAt
   * timestamp.
   *
   * @param postcode The new postal code.
   */
  public void setPostcode(String postcode) {
    this.postcode = postcode;
    update();
  }

  /**
   * Sets the status of the order and updates the updatedAt timestamp.
   *
   * @param orderStatus The new order status.
   */
  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
    update();
  }

  /**
   * Updates the updatedAt timestamp to the current date and time. This method is called internally
   * whenever any attribute of the order is modified.
   */
  private void update() {
    this.updatedAt = LocalDateTime.now();
  }
}
