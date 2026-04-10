package com.software.testingjava.module08_refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.software.testingjava.badcode.LegacyAuditLogger;
import com.software.testingjava.badcode.LegacyCheckoutManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LegacyCheckoutManagerCharacterizationTest {
    private LegacyCheckoutManager checkoutManager;

    @BeforeEach
    void setUp() {
        checkoutManager = new LegacyCheckoutManager();
        LegacyAuditLogger.lastEntry = "";
    }

    @Test
    void shouldReturnSuccessForHappyPathCheckout() {
        // Arrange

        // Act
        String result = checkoutManager.checkout("C-LEGACY", "legacy@example.com", "BOOK-1", 2, 10.0);

        // Assert
        assertEquals("SUCCESS", result);
        assertEquals("SUCCESS:BOOK-1:20.0", LegacyAuditLogger.lastEntry);
    }

    @Test
    void shouldReturnOutOfStockWhenLegacyInventoryRejectsItem() {
        // Arrange

        // Act
        String result = checkoutManager.checkout("C-LEGACY", "legacy@example.com", "OUT-OF-STOCK", 1, 10.0);

        // Assert
        assertEquals("OUT_OF_STOCK", result);
        assertEquals("OUT_OF_STOCK", LegacyAuditLogger.lastEntry);
    }
}
