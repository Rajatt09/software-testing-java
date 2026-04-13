package com.software.testingjava.patterns;

import com.software.testingjava.domain.Order;
import java.math.BigDecimal;

public class DiscountCalculator {
    public BigDecimal calculateDiscountedTotal(Order order) {
        BigDecimal total = order.totalAmount();

        if (order.getCustomer().isPremiumMember()) {
            BigDecimal discount = total.multiply(new BigDecimal("0.10"));
            return total.subtract(discount).setScale(2);
        }

        return total;

//        throw new UnsupportedOperationException("Implement as part of Module 05 TDD");
    }
}
