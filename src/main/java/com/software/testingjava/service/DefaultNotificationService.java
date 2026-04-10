package com.software.testingjava.service;

import com.software.testingjava.domain.Order;
import com.software.testingjava.external.EmailClient;

public class DefaultNotificationService implements NotificationService {
    private final EmailClient emailClient;

    public DefaultNotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void sendOrderConfirmation(Order order) {
        emailClient.send(order.getCustomer().getEmail(), "Order confirmed: " + order.getOrderId());
    }
}
