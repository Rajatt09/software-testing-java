package com.software.testingjava.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String orderId;
    private final Customer customer;
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order(String orderId, Customer customer, List<OrderItem> items) {
        this.orderId = Objects.requireNonNull(orderId);
        this.customer = Objects.requireNonNull(customer);
        this.items = List.copyOf(items);
        this.status = OrderStatus.CREATED;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(OrderStatus status) {
        this.status = Objects.requireNonNull(status);
    }

    public BigDecimal totalAmount() {
        return items.stream()
                .map(OrderItem::totalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
