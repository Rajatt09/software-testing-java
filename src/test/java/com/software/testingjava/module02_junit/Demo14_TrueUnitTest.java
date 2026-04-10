package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo14_TrueUnitTest {
    
    // DEMO: A "Unit" is a BEHAVIOR, not a CLASS. 
    // Here we are testing Order totaling. Order heavily relies on OrderItem and PricingEngine.
    // Notice we do NOT mock OrderItem. We do NOT mock PricingEngine (if it were injected).
    // We instantiate real objects because they are pure domain logic without side-effects (I/O).
    // If we mocked OrderItem, the test would be incredibly brittle and unreadable.
    
    @Test
    void shouldCalculateTotalUsingRealSubUnits() {
        // Arrange
        Customer c = new Customer("1", "Alice", "alice@test.com", true);
        OrderItem item1 = new OrderItem("LAPTOP", 1, new BigDecimal("1000.00"));
        OrderItem item2 = new OrderItem("MOUSE", 2, new BigDecimal("50.00"));
        
        Order order = new Order("O-123", c, List.of(item1, item2));
        
        // Act
        BigDecimal total = order.totalAmount();
        
        // Assert
        // We know exactly what the domain objects yield. 
        assertEquals(new BigDecimal("1100.00"), total);
    }
}
