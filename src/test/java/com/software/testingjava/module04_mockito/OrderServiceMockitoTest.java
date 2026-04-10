package com.software.testingjava.module04_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderReceipt;
import com.software.testingjava.domain.OrderStatus;
import com.software.testingjava.domain.PaymentResult;
import com.software.testingjava.service.InventoryService;
import com.software.testingjava.service.NotificationService;
import com.software.testingjava.service.OrderService;
import com.software.testingjava.service.PaymentService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderServiceMockitoTest {

    @Test
    void shouldPlaceOrderWhenDependenciesReportSuccess() {
        // Arrange
        InventoryService inventoryService = mock(InventoryService.class);
        when(inventoryService.isAvailable("BOOK-1", 2)).thenReturn(true);

        PaymentService paymentService = mock(PaymentService.class);
        when(paymentService.processPayment(any())).thenReturn(PaymentResult.success("txn-444"));

        NotificationService notificationService = mock(NotificationService.class);
        OrderService orderService = new OrderService(inventoryService, paymentService, notificationService);
        Order order = sampleOrder();

        // Act
        OrderReceipt receipt = orderService.placeOrder(order);

        // Assert
        assertEquals(OrderStatus.CONFIRMED, receipt.getStatus());
        verify(inventoryService).reserve("BOOK-1", 2);
        verify(paymentService).processPayment(any());
        verify(notificationService).sendOrderConfirmation(order);
    }

    @Test
    void shouldFailFastWhenInventoryIsUnavailable() {
        // Arrange
        InventoryService inventoryService = mock(InventoryService.class);
        when(inventoryService.isAvailable("BOOK-1", 2)).thenReturn(false);

        PaymentService paymentService = mock(PaymentService.class);
        NotificationService notificationService = mock(NotificationService.class);
        OrderService orderService = new OrderService(inventoryService, paymentService, notificationService);
        Order order = sampleOrder();

        // Act
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> orderService.placeOrder(order));

        // Assert
        assertEquals("Inventory not available for sku: BOOK-1", exception.getMessage());
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-4", "Noah", "noah@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("15.00"));
        return new Order("O-400", customer, List.of(item));
    }
}
