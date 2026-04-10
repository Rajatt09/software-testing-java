package com.software.testingjava.module03_test_doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderReceipt;
import com.software.testingjava.domain.OrderStatus;
import com.software.testingjava.domain.PaymentRequest;
import com.software.testingjava.domain.PaymentResult;
import com.software.testingjava.service.InventoryService;
import com.software.testingjava.service.NotificationService;
import com.software.testingjava.service.OrderService;
import com.software.testingjava.service.PaymentService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TestDoublesWorkshopTest {

    @Test
    void shouldPlaceOrderUsingFakeInventoryAndStubPaymentService() {
        // Arrange
        FakeInventoryService fakeInventoryService = new FakeInventoryService();
        fakeInventoryService.put("BOOK-1", 5);
        StubPaymentService stubPaymentService = new StubPaymentService();
        RecordingNotificationService notificationService = new RecordingNotificationService();
        OrderService orderService = new OrderService(fakeInventoryService, stubPaymentService, notificationService);
        Order order = sampleOrder();

        // Act
        OrderReceipt receipt = orderService.placeOrder(order);

        // Assert
        assertEquals(OrderStatus.CONFIRMED, receipt.getStatus());
        assertEquals(3, fakeInventoryService.remaining("BOOK-1"));
        assertTrue(notificationService.wasCalled());
    }

    @Test
    void shouldShowWhyFakeCanBeClearerThanInteractionOnlyDouble() {
        // Arrange
        FakeInventoryService fakeInventoryService = new FakeInventoryService();
        fakeInventoryService.put("BOOK-1", 2);

        // Act
        boolean available = fakeInventoryService.isAvailable("BOOK-1", 2);
        fakeInventoryService.reserve("BOOK-1", 2);

        // Assert
        assertTrue(available);
        assertEquals(0, fakeInventoryService.remaining("BOOK-1"));
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-3", "Mina", "mina@example.com", true);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("25.00"));
        return new Order("O-300", customer, List.of(item));
    }

    private static class FakeInventoryService implements InventoryService {
        private final Map<String, Integer> stock = new HashMap<>();

        void put(String sku, int quantity) {
            stock.put(sku, quantity);
        }

        int remaining(String sku) {
            return stock.getOrDefault(sku, 0);
        }

        @Override
        public boolean isAvailable(String sku, int quantity) {
            return stock.getOrDefault(sku, 0) >= quantity;
        }

        @Override
        public void reserve(String sku, int quantity) {
            stock.put(sku, stock.get(sku) - quantity);
        }
    }

    private static class StubPaymentService implements PaymentService {
        @Override
        public PaymentResult processPayment(PaymentRequest request) {
            return PaymentResult.success("stubbed-" + request.getOrderId());
        }
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
