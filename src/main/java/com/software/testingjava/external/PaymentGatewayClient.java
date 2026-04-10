package com.software.testingjava.external;

import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;

public interface PaymentGatewayClient {
    PaymentResult charge(PaymentRequest request);
}
