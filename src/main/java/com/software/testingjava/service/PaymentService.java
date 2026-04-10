package com.software.testingjava.service;

import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;

public interface PaymentService {
    PaymentResult processPayment(PaymentRequest request);
}
