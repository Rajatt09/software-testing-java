package com.software.testingjava.module01_basics;

import com.software.testingjava.domain.PricingEngine;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Demo01_BadAssertionsTest {
    @Test
    void demo_weakAssertion() {
        PricingEngine engine = new PricingEngine();
        BigDecimal total = engine.calculateTotal(new BigDecimal("100"), 1, false);
        
        // This fails with purely "Expected true but was false" 
        // We will break PricingEngine live to show this.
        assertTrue(total.compareTo(new BigDecimal("105")) == 0);
    }
}