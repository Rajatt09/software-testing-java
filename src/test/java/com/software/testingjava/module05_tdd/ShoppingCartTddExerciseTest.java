package com.software.testingjava.module05_tdd;

import com.software.testingjava.domain.ShoppingCart;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTddExerciseTest {

    // EXERCISE: Remove @Disabled, let the test fail, then write minimal code in ShoppingCart.java to make it pass.

    @Test
    @Disabled("Remove this to start the exercise")
    void shouldAddNewItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("BOOK-1", 1);
        
        assertTrue(cart.containsItem("BOOK-1"));
        assertEquals(1, cart.getTotalQuantity());
    }
    
    @Test
    @Disabled("Remove this to start the exercise")
    void shouldCombineQuantitiesForSameItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("BOOK-1", 1);
        cart.addItem("BOOK-1", 2);
        
        assertEquals(3, cart.getTotalQuantity());
    }
}
