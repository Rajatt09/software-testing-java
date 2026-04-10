package com.software.testingjava.module05_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.patterns.DiscountCalculator;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTddTest {

    @Test
    void shouldApplyTenPercentDiscountForPremiumCustomers() {
        // Arrange
        DiscountCalculator calculator = new DiscountCalculator();
        Order order = premiumOrder();

        // Act
        BigDecimal discountedTotal = calculator.calculateDiscountedTotal(order);

        // Assert
        assertEquals(new BigDecimal("90.00"), discountedTotal);
    }

    @Test
    void shouldLeaveStandardOrdersUnchanged() {
        // Arrange
        DiscountCalculator calculator = new DiscountCalculator();
        Order order = standardOrder();

        // Act
        BigDecimal discountedTotal = calculator.calculateDiscountedTotal(order);

        // Assert
        assertEquals(new BigDecimal("100.00"), discountedTotal);
    }

    private Order premiumOrder() {
        Customer customer = new Customer("C-5", "Priya", "priya@example.com", true);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("50.00"));
        return new Order("O-500", customer, List.of(item));
    }

    private Order standardOrder() {
        Customer customer = new Customer("C-6", "Aman", "aman@example.com", false);
        OrderItem item = new OrderItem("BOOK-2", 2, new BigDecimal("50.00"));
        return new Order("O-501", customer, List.of(item));
    }
}
