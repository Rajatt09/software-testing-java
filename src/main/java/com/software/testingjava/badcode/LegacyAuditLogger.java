package com.software.testingjava.badcode;

public class LegacyAuditLogger {
    public static String lastEntry = "";

    private LegacyAuditLogger() {
    }

    public static void log(String entry) {
        lastEntry = entry;
        System.out.println("AUDIT: " + entry);
    }
}
