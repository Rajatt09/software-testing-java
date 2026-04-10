package com.software.testingjava.domain;

import java.util.Objects;

public class PaymentResult {
    private final boolean successful;
    private final String transactionId;
    private final String message;

    private PaymentResult(boolean successful, String transactionId, String message) {
        this.successful = successful;
        this.transactionId = transactionId;
        this.message = Objects.requireNonNull(message);
    }

    public static PaymentResult success(String transactionId) {
        return new PaymentResult(true, Objects.requireNonNull(transactionId), "Payment processed");
    }

    public static PaymentResult failure(String message) {
        return new PaymentResult(false, null, message);
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }
}
