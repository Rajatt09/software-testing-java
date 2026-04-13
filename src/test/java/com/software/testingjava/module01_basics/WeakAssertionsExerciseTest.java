package com.software.testingjava.module01_basics;

import com.software.testingjava.domain.OrderItem;
import com.software.testingjava.domain.PricingEngine;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WeakAssertionsExerciseTest {

    // EXERCISE: Remove @Disabled, run the test, and see how bad the failure message is ("Expected true but was false").
    // Re-write these tests using strong assertions like assertEquals or assertThrows to make the error obvious.

    @Test
//    @Disabled("Remove this to start the exercise")
    void testPremiumDiscount() {

        PricingEngine engine = new PricingEngine();

        BigDecimal total = engine.calculateTotal(new BigDecimal("150"), 2, true);
        
        // This is a weak assertion. It fails, but tells you nothing about WHY.
        // Change this to assertEquals(...)
//        assertTrue(total.compareTo(new BigDecimal("140")) == 0);

        // Assert
        assertEquals(new BigDecimal("140.00"),total);
    }

    @Test
//    @Disabled("Remove this to start the exercise")
    void testNegativeQuantity() {

        PricingEngine engine = new PricingEngine();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> engine.calculateTotal(new BigDecimal("150"), -1, true)
        );

        assertEquals("Quantity must be positive", exception.getMessage());

//        PricingEngine engine = new PricingEngine();
        
        // This relies on a messy try-catch. Change this to use assertThrows()
//        boolean threw = false;
//        try {
//            engine.calculateTotal(new BigDecimal("150"), -1, true);
//        } catch (IllegalArgumentException e) {
//            threw = true;
//        }


//        assertTrue(threw);

    }
}
