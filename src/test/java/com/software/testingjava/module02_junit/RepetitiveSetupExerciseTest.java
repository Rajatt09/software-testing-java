package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.math.BigDecimal;
import java.util.List;

class RepetitiveSetupExerciseTest {

    // EXERCISE: Refactor this class to eliminate duplicated setup code using @BeforeEach 
    // and potentially a Test Data Builder (e.g. TestOrderBuilder).

    private TestOrderBuilder baseBuilder;

    @BeforeEach
    void setUp() {
        baseBuilder = TestOrderBuilder.aValidOrder();
    }

    @Test
//    @Disabled("Remove this to start the exercise")
    void shouldCalculateTotalForRegularCustomer() {

        Order order = baseBuilder.withPremium(false).build();

        BigDecimal total = order.totalAmount();

        assertNotNull(total);

        // --- MESSY SETUP ---
//        Customer customer = new Customer("C-1", "John", "john@example.com", false);
//        OrderItem item1 = new OrderItem("SKU-1", 1, new BigDecimal("10.00"));
//        OrderItem item2 = new OrderItem("SKU-2", 2, new BigDecimal("20.00"));
//        Order order = new Order("O-1", customer, List.of(item1, item2));
//        OrderService service = new OrderService(null, null, null); // assuming nulls are ok for this calc
        // -------------------

//        assertNotNull(order.totalAmount());
    }

    @Test
//    @Disabled("Remove this to start the exercise")
    void shouldCalculateTotalForPremiumCustomer() {

        Order order = baseBuilder.withPremium(true).build();

        BigDecimal total = order.totalAmount();

        assertNotNull(total);

        // --- MESSY SETUP EXACTLY COPIED ---
//        Customer customer = new Customer("C-1", "John", "john@example.com", true); // only this changed
//        OrderItem item1 = new OrderItem("SKU-1", 1, new BigDecimal("10.00"));
//        OrderItem item2 = new OrderItem("SKU-2", 2, new BigDecimal("20.00"));
//        Order order = new Order("O-1", customer, List.of(item1, item2));
//        OrderService service = new OrderService(null, null, null);
        // -------------------

//        assertNotNull(order.totalAmount());
    }

    static class TestOrderBuilder {
        private boolean isPremium = false;

        TestOrderBuilder withPremium(boolean premium) {
            this.isPremium = premium;
            return this;
        }

        Order build() {
            Customer customer = new Customer("C-1", "John", "john@example.com", isPremium);
            OrderItem item1 = new OrderItem("SKU-1", 1, new BigDecimal("10.00"));
            OrderItem item2 = new OrderItem("SKU-2", 2, new BigDecimal("20.00"));
            return new Order("O-1", customer, List.of(item1, item2));
        }

        static TestOrderBuilder aValidOrder() {
            return new TestOrderBuilder();
        }
    }
}
