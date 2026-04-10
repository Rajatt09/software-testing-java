package com.software.testingjava.module01_basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.PaymentResult;
import com.software.testingjava.domain.Customer;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderDomainBasicsTest {

    @Test
    void shouldCalculateOrderTotalForSingleItemOrder() {
        // Arrange
        Order order = sampleOrder();

        // Act
        BigDecimal total = order.totalAmount();

        // Assert
        assertEquals(new BigDecimal("40.00"), total);
        assertNotNull(order.getCustomer());
    }

    @Test
    void shouldCreateSuccessAndFailurePaymentResults() {
        // Arrange
        PaymentResult success = PaymentResult.success("txn-100");
        PaymentResult failure = PaymentResult.failure("Card declined");

        // Act
        boolean successFlag = success.isSuccessful();
        boolean failureFlag = failure.isSuccessful();

        // Assert
        assertTrue(successFlag);
        assertFalse(failureFlag);
        assertEquals("txn-100", success.getTransactionId());
        assertEquals("Card declined", failure.getMessage());
    }

    @Test
    void shouldRejectInvalidOrderItemQuantity() {
        // Arrange

        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem("BOOK-1", 0, new BigDecimal("20.00"))
        );

        // Assert
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    private Order sampleOrder() {
        Customer customer = new Customer("C-1", "Asha", "asha@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("20.00"));
        return new Order("O-100", customer, List.of(item));
    }
}
