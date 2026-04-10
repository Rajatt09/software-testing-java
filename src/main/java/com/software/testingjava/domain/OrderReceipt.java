package com.software.testingjava.domain;

import java.util.Objects;

public class OrderReceipt {
    private final String orderId;
    private final OrderStatus status;
    private final String paymentReference;

    public OrderReceipt(String orderId, OrderStatus status, String paymentReference) {
        this.orderId = Objects.requireNonNull(orderId);
        this.status = Objects.requireNonNull(status);
        this.paymentReference = paymentReference;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getPaymentReference() {
        return paymentReference;
    }
}
