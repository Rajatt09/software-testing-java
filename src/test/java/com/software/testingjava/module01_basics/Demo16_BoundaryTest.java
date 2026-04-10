package com.software.testingjava.module01_basics;

import com.software.testingjava.domain.PricingEngine;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo16_BoundaryTest {

    // DEMO: Negative Path & Boundaries
    // The spec says: "Premium members get $10 off if subtotal is strictly > $100."
    // We must test exactly $100.00 and exactly $100.01.
    
    @Test
    void shouldNotApplyDiscountRightOnTheBoundary() {
        PricingEngine engine = new PricingEngine();
        
        // Exact boundary: 100.00
        BigDecimal total = engine.calculateTotal(new BigDecimal("100.00"), 1, true);
        
        // No discount applied because it is not STRICTLY greater than 100
        assertEquals(new BigDecimal("100.00"), total);
    }
    
    @Test
    void shouldApplyDiscountJustAboveTheBoundary() {
        PricingEngine engine = new PricingEngine();
        
        // Just over boundary: 100.01
        BigDecimal total = engine.calculateTotal(new BigDecimal("100.01"), 1, true);
        
        // Discount of 10.00 applied
        assertEquals(new BigDecimal("90.01"), total);
    }
}
