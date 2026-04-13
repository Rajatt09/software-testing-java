package com.software.testingjava.module06_bdd;

import com.software.testingjava.domain.ShoppingCart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImperativeToBddExerciseTest {

    // EXERCISE: Refactor this messy test into clear Given / When / Then blocks. Rename the test method accordingly.

    @Test
//    @Disabled("Remove this to start the exercise")
    void shouldReturnCorrectTotalAfterAddingItems() {
//        ShoppingCart cart = new ShoppingCart();
//        assertEquals(0, cart.getTotalQuantity());
//        cart.addItem("PENS", 5);
//        assertEquals(5, cart.getTotalQuantity());
//        cart.addItem("PAPER", 1);
//        int total = cart.getTotalQuantity();
//        assertEquals(6, total);
        // It's hard to read what the actual "Act" of this test is.

        // Given
        ShoppingCart cart = new ShoppingCart();

        // When
        cart.addItem("PENS", 5);
        cart.addItem("PAPER", 1);
        int total = cart.getTotalQuantity();

        // Then
        assertEquals(6, total);
    }
}
