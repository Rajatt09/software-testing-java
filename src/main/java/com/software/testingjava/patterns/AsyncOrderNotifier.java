package com.software.testingjava.patterns;

import com.software.testingjava.domain.Order;
import com.software.testingjava.service.NotificationService;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncOrderNotifier {
    private final NotificationService notificationService;
    private final Executor executor;

    public AsyncOrderNotifier(NotificationService notificationService) {
        this(notificationService, Executors.newCachedThreadPool());
    }

    public AsyncOrderNotifier(NotificationService notificationService, Executor executor) {
        this.notificationService = Objects.requireNonNull(notificationService);
        this.executor = Objects.requireNonNull(executor);
    }

    public CompletableFuture<Boolean> sendConfirmation(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            notificationService.sendOrderConfirmation(order);
            return true;
        }, executor);
    }

    public CompletableFuture<Boolean> sendConfirmationWithDelay(Order order, Duration delay) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(delay.toMillis());
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while sending notification", exception);
            }

            notificationService.sendOrderConfirmation(order);
            return true;
        }, executor);
    }
}
