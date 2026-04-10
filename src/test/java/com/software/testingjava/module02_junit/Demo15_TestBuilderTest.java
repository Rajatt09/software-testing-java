package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo15_TestBuilderTest {
    
    // DEMO: Fixture discipline.
    // Instead of copying 10 lines of setup into every single test...
    
    @Test
    void testWithBuilder() {
        // Arrange
        Order order = TestOrderBuilder.aValidOrder()
                .withCustomer(new Customer("1", "Bob", "b@b.com", true))
                .withItem("CPU", 1, new BigDecimal("500"))
                .build();
                
        // Act & Assert
        assertEquals(new BigDecimal("500"), order.totalAmount());
    }

    // Usually builders live in a dedicated class, but we inline it here for the demo.
    public static class TestOrderBuilder {
        private Customer customer = new Customer("Default", "Def", "def@test.com", false);
        private List<OrderItem> items = List.of(new OrderItem("DEFAULT", 1, BigDecimal.TEN));
        
        public static TestOrderBuilder aValidOrder() {
            return new TestOrderBuilder();
        }
        
        public TestOrderBuilder withCustomer(Customer c) {
            this.customer = c;
            return this;
        }
        
        public TestOrderBuilder withItem(String sku, int q, BigDecimal price) {
            this.items = List.of(new OrderItem(sku, q, price));
            return this;
        }
        
        public Order build() {
            return new Order("O-TEST", customer, items);
        }
    }
}
