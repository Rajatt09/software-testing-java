package com.software.testingjava.domain;

import java.math.BigDecimal;

public class PricingEngine {
    public BigDecimal calculateTotal(BigDecimal subtotal, int itemQuantity, boolean isPremiumMember) {
        if (itemQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        BigDecimal discount = BigDecimal.ZERO;
        if (isPremiumMember && subtotal.compareTo(new BigDecimal("100")) > 0) {
            discount = new BigDecimal("10.00");
        }
        
        BigDecimal shippingCost = isPremiumMember ? BigDecimal.ZERO : new BigDecimal("5.00");
        return subtotal.subtract(discount).add(shippingCost);
    }
}
