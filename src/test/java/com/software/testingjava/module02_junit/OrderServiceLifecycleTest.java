package com.software.testingjava.module02_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceLifecycleTest {
    private InMemoryInventoryService inventoryService;
    private PaymentService paymentService;
    private RecordingNotificationService notificationService;
    private OrderService orderService;
    private int tearDownCount;

    @BeforeEach
    void setUp() {
        inventoryService = new InMemoryInventoryService();
        inventoryService.addStock("BOOK-1", 10);
        paymentService = request -> PaymentResult.success("paid-" + request.getOrderId());
        notificationService = new RecordingNotificationService();
        orderService = new OrderService(inventoryService, paymentService, notificationService);
        tearDownCount = 0;
    }

    @AfterEach
    void tearDown() {
        inventoryService = null;
        paymentService = null;
        notificationService = null;
        orderService = null;
        tearDownCount++;
    }

    @Test
    void shouldConfirmOrderUsingReusableFixture() {
        // Arrange
        Order order = sampleOrder();

        // Act
        OrderReceipt receipt = orderService.placeOrder(order);

        // Assert
        assertEquals(OrderStatus.CONFIRMED, receipt.getStatus());
        assertTrue(notificationService.wasCalled());
    }

    @Test
    void shouldReserveStockDuringOrderPlacement() {
        // Arrange
        Order order = sampleOrder();

        // Act
        orderService.placeOrder(order);

        // Assert
        assertTrue(inventoryService.isAvailable("BOOK-1", 8));
        assertEquals(0, tearDownCount);
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-2", "Ravi", "ravi@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("20.00"));
        return new Order("O-200", customer, List.of(item));
    }

    private static class RecordingNotificationService implements NotificationService {
        private boolean called;

        @Override
        public void sendOrderConfirmation(Order order) {
            called = true;
        }

        boolean wasCalled() {
            return called;
        }
    }
}
