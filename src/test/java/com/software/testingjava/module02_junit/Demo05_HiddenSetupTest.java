package com.software.testingjava.module02_junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Demo05_HiddenSetupTest {
    private String databaseConnectionUrl;
    private int timeout;
    private String testUser;
    
    @BeforeEach
    void heavySetup() {
        // This is a smell: 
        // We initialize 10 fields here, but individual tests only need 1 or 2 of them.
        databaseConnectionUrl = "jdbc:test:mem";
        timeout = 5000;
        testUser = "admin";
    }

    @Test
    void testTimeoutConfig() {
        // Obfuscated dependency - where did 'timeout' come from?
        System.out.println("Timeout is " + timeout);
    }
}
