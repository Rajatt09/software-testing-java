package com.software.testingjava.service;

import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;
import com.software.testingjava.external.PaymentGatewayClient;

public class GatewayPaymentService implements PaymentService {
    private final PaymentGatewayClient paymentGatewayClient;

    public GatewayPaymentService(PaymentGatewayClient paymentGatewayClient) {
        this.paymentGatewayClient = paymentGatewayClient;
    }

    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        return paymentGatewayClient.charge(request);
    }
}
