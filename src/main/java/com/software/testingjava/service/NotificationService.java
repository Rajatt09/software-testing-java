package com.software.testingjava.service;

import com.software.testingjava.domain.Order;

public interface NotificationService {
    void sendOrderConfirmation(Order order);
}
