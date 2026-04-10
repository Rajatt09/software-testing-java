package com.software.testingjava.module02_junit;

import com.software.testingjava.domain.Customer;
import com.software.testingjava.domain.Order;
import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.OrderStatus;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo03_MessyStructureTest {
    @Test
    void demo_interwovenStructure() {
        Customer c = new Customer("1", "Bob", "bob@example.com", false);
        OrderItem item = new OrderItem("SKU", 1, new BigDecimal("10"));
        Order o = new Order("O-1", c, List.of(item));
        assertEquals(OrderStatus.CREATED, o.getStatus());
        o.updateStatus(OrderStatus.CONFIRMED);
        assertEquals(OrderStatus.CONFIRMED, o.getStatus());
        o.updateStatus(OrderStatus.FAILED);
        assertEquals(OrderStatus.FAILED, o.getStatus());
    }
}
