package com.software.testingjava.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentRequest {
    private final String orderId;
    private final BigDecimal amount;

    public PaymentRequest(String orderId, BigDecimal amount) {
        this.orderId = Objects.requireNonNull(orderId);
        this.amount = Objects.requireNonNull(amount);
    }

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
