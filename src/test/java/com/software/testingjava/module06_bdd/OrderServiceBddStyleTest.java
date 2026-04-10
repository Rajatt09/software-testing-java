package com.software.testingjava.module06_bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderReceipt;
import com.software.testingjava.domain.OrderStatus;
import com.software.testingjava.domain.PaymentResult;
import com.software.testingjava.service.InMemoryInventoryService;
import com.software.testingjava.service.NotificationService;
import com.software.testingjava.service.OrderService;
import com.software.testingjava.service.PaymentService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderServiceBddStyleTest {

    @Test
    void givenAvailableStockWhenOrderIsPlacedThenOrderIsConfirmed() {
        // Arrange (Given)
        InMemoryInventoryService inventoryService = new InMemoryInventoryService();
        inventoryService.addStock("BOOK-1", 5);
        PaymentService paymentService = request -> PaymentResult.success("bdd-" + request.getOrderId());
        NotificationService notificationService = order -> { };
        OrderService orderService = new OrderService(inventoryService, paymentService, notificationService);
        Order order = sampleOrder();

        // Act (When)
        OrderReceipt receipt = orderService.placeOrder(order);

        // Assert (Then)
        assertEquals(OrderStatus.CONFIRMED, receipt.getStatus());
    }

    @Test
    void givenUnavailableStockWhenOrderIsPlacedThenOrderPlacementFails() {
        // Arrange (Given)
        InMemoryInventoryService inventoryService = new InMemoryInventoryService();
        PaymentService paymentService = request -> PaymentResult.success("bdd-" + request.getOrderId());
        NotificationService notificationService = order -> { };
        OrderService orderService = new OrderService(inventoryService, paymentService, notificationService);
        Order order = sampleOrder();

        // Act (When)
        OrderStatus status;
        try {
            orderService.placeOrder(order);
            status = order.getStatus();
        } catch (IllegalStateException exception) {
            status = order.getStatus();
        }

        // Assert (Then)
        assertEquals(OrderStatus.FAILED, status);
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-7", "Sara", "sara@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 1, new BigDecimal("35.00"));
        return new Order("O-600", customer, List.of(item));
    }
}
