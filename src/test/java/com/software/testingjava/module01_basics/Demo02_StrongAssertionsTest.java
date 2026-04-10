package com.software.testingjava.module01_basics;

import com.software.testingjava.domain.PricingEngine;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo02_StrongAssertionsTest {
    @Test
    void demo_strongAssertion() {
        PricingEngine engine = new PricingEngine();
        BigDecimal total = engine.calculateTotal(new BigDecimal("100"), 1, false);
        
        // This tells us exactly the expected vs actual value
        assertEquals(new BigDecimal("105.00"), total);
    }
}
