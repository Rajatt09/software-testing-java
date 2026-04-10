package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderStatus;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo04_CleanAaaTest {
    @Test
    void demo_clearAaaStructure_Confirm() {
        // Arrange
        Customer c = new Customer("1", "Bob", "bob@example.com", false);
        Order o = new Order("O-1", c, List.of(new OrderItem("SKU", 1, new BigDecimal("10"))));
        
        // Act
        o.updateStatus(OrderStatus.CONFIRMED);
        
        // Assert
        assertEquals(OrderStatus.CONFIRMED, o.getStatus());
    }
}
