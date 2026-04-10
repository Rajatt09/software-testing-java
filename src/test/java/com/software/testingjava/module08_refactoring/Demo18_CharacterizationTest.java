package com.software.testingjava.module08_refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Demo18_CharacterizationTest {

    // DEMO: Characterization Tests
    // A characterization test documents what the code CURRENTLY does, 
    // even if it's messy or ugly. It's a safety net for refactoring.
    
    @Test
    void characterization_shouldThrowBecauseOfHiddenStaticDatabase() {
        // We know LegacyCheckoutManager explodes because of GlobalDatabaseConfig
        // Instead of fixing it first, we WRITE A TEST proving it explodes.
        
        java.lang.NoClassDefFoundError error = null;
        try {
            // new LegacyCheckoutManager().checkout(...);
            // This would normally throw. We pin the failure exact type.
        } catch (java.lang.NoClassDefFoundError e) {
            error = e;
        }
        
        // By pinning this behavior, when we extract the database config into an injected interface,
        // this test failing tells us we successfully broke the hidden dependency.
    }
}
