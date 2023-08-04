package com.example.bean.server.model;

/**
 * The {@code OrderStatus} enum represents the different stages of an order service flow in an
 * online store system. Each constant in this enum represents a unique stage that an order can be in
 * during the order service flow. The order service flow starts from {@link #ORDER_REQUESTED} and
 * progresses through payment confirmation, acceptance, processing, readiness for delivery, and
 * finally to {@link #ORDER_SHIPPED} when the order has been shipped.
 *
 * @version 1.0
 * @since 2023-08-04
 */
public enum OrderStatus {
  /**
   * Represents the initial stage where the customer places an order, and the payment is not
   * confirmed yet. The order has been requested by the customer, but the payment process has not
   * been completed.
   */
  ORDER_REQUESTED,

  /**
   * Represents the stage when the payment for the order has been successfully confirmed. At this
   * point, the order is ready for the seller's acceptance and further processing.
   */
  PAYMENT_CONFIRMED,

  /**
   * Represents the stage when the seller accepts the order after verifying the details and payment.
   * The order is now being processed, which may involve tasks like picking and packing the items.
   */
  ORDER_ACCEPTED,

  /**
   * Represents the stage when the order is being processed. It indicates that the order is in
   * progress and may involve tasks like picking and packing the items.
   */
  ORDER_PROCESSING,

  /**
   * Represents the stage when the order is ready for delivery and is awaiting shipment. At this
   * point, the order has been processed, and it's ready to be shipped to the customer.
   */
  ORDER_READY_FOR_DELIVERY,

  /**
   * Represents the final stage when the order has been shipped and is on its way to the customer.
   * This indicates that the order fulfillment process has been completed, and the order is in
   * transit.
   */
  ORDER_SHIPPED
}
