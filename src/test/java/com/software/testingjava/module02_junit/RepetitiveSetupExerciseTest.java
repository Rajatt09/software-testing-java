package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.service.OrderService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.math.BigDecimal;
import java.util.List;

class RepetitiveSetupExerciseTest {

    // EXERCISE: Refactor this class to eliminate duplicated setup code using @BeforeEach 
    // and potentially a Test Data Builder (e.g. TestOrderBuilder).

    @Test
    @Disabled("Remove this to start the exercise")
    void shouldCalculateTotalForRegularCustomer() {
        // --- MESSY SETUP ---
        Customer customer = new Customer("C-1", "John", "john@example.com", false);
        OrderItem item1 = new OrderItem("SKU-1", 1, new BigDecimal("10.00"));
        OrderItem item2 = new OrderItem("SKU-2", 2, new BigDecimal("20.00"));
        Order order = new Order("O-1", customer, List.of(item1, item2));
        OrderService service = new OrderService(null, null, null); // assuming nulls are ok for this calc
        // -------------------

        assertNotNull(order.totalAmount());
    }

    @Test
    @Disabled("Remove this to start the exercise")
    void shouldCalculateTotalForPremiumCustomer() {
        // --- MESSY SETUP EXACTLY COPIED ---
        Customer customer = new Customer("C-1", "John", "john@example.com", true); // only this changed
        OrderItem item1 = new OrderItem("SKU-1", 1, new BigDecimal("10.00"));
        OrderItem item2 = new OrderItem("SKU-2", 2, new BigDecimal("20.00"));
        Order order = new Order("O-1", customer, List.of(item1, item2));
        OrderService service = new OrderService(null, null, null);
        // -------------------

        assertNotNull(order.totalAmount());
    }
}
