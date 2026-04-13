package com.software.testingjava.module04_mockito;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OverMockedExerciseTest {

    // EXERCISE: This test suffers from the Over-Mocking anti-pattern (mocking value objects).
    // Strip out all the Mockito calls and replace them with standard new Order() and new Customer() calls.

    @Test
//    @Disabled("Remove this to start the exercise")
    void shouldReportCustomerNameFromOrder() {
        // Arrange
//        Order mockedOrder = mock(Order.class);
//        Customer mockedCustomer = mock(Customer.class);
        
//        when(mockedCustomer.getName()).thenReturn("Alice");
//        when(mockedOrder.getCustomer()).thenReturn(mockedCustomer);

        Customer customer = new Customer("A-4", "Alice", "alice@example.com", false);
        OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("15.00"));
        Order sampleOrder = new Order("O-400", customer, List.of(item));
        
        // Act
        String name = sampleOrder.getCustomer().getName();
        
        // Assert
        assertEquals("Alice", name);
    }
}
