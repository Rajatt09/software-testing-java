package com.software.testingjava.external;

import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;

public class StubPaymentGatewayClient implements PaymentGatewayClient {
    @Override
    public PaymentResult charge(PaymentRequest request) {
        if (request.getAmount().signum() <= 0) {
            return PaymentResult.failure("Amount must be positive");
        }

        return PaymentResult.success("stub-txn-" + request.getOrderId());
    }
}
