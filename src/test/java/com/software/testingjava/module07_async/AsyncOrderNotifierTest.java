package com.software.testingjava.module07_async;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.patterns.AsyncOrderNotifier;
import com.software.testingjava.service.NotificationService;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AsyncOrderNotifierTest {

    @Test
//    @Disabled("Demonstrates a flaky test that depends on timing guesses.")
    void shouldDemonstrateFlakyTimingBasedAsyncTest() throws Exception {
        // Arrange
        RecordingNotificationService notificationService = new RecordingNotificationService();
        AsyncOrderNotifier notifier = new AsyncOrderNotifier(notificationService);
        Order order = sampleOrder();

        // Act
        notifier.sendConfirmationWithDelay(order, Duration.ofMillis(50));
        Thread.sleep(10);

        // Assert
        assertTrue(notificationService.wasCalled());
    }

    @Test
    void shouldSendConfirmationDeterministicallyWithDirectExecutor() throws Exception {
        // Arrange
        RecordingNotificationService notificationService = new RecordingNotificationService();
        AsyncOrderNotifier notifier = new AsyncOrderNotifier(notificationService, Runnable::run);
        Order order = sampleOrder();

        // Act
        boolean result = notifier.sendConfirmation(order).get(1, TimeUnit.SECONDS);

        // Assert
        assertTrue(result);
        assertTrue(notificationService.wasCalled());
        assertFalse(notifier.sendConfirmationWithDelay(order, Duration.ZERO).isCompletedExceptionally());
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-8", "Lina", "lina@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 1, new BigDecimal("22.00"));
        return new Order("O-700", customer, List.of(item));
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
