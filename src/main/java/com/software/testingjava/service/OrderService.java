package com.software.testingjava.service;

import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderReceipt;
import com.software.testingjava.domain.OrderStatus;
import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;

public class OrderService {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderService(
            InventoryService inventoryService,
            PaymentService paymentService,
            NotificationService notificationService
    ) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public OrderReceipt placeOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            if (!inventoryService.isAvailable(item.getSku(), item.getQuantity())) {
                order.updateStatus(OrderStatus.FAILED);
                throw new IllegalStateException("Inventory not available for sku: " + item.getSku());
            }
        }

        for (OrderItem item : order.getItems()) {
            inventoryService.reserve(item.getSku(), item.getQuantity());
        }

        order.updateStatus(OrderStatus.RESERVED);

        PaymentResult paymentResult = paymentService.processPayment(
                new PaymentRequest(order.getOrderId(), order.totalAmount())
        );

        if (!paymentResult.isSuccessful()) {
            order.updateStatus(OrderStatus.FAILED);
            throw new IllegalStateException(paymentResult.getMessage());
        }

        order.updateStatus(OrderStatus.PAID);
        notificationService.sendOrderConfirmation(order);
        order.updateStatus(OrderStatus.CONFIRMED);

        return new OrderReceipt(order.getOrderId(), order.getStatus(), paymentResult.getTransactionId());
    }
}
