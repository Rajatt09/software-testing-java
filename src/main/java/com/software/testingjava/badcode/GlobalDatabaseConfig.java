package com.software.testingjava.badcode;

public class GlobalDatabaseConfig {
    public static boolean isReadonly() {
        // Will throw in test environments unless overridden or refactored away!
        // throw new RuntimeException("No DB Connection in test environment!");
        return false;
    }
}
