package com.software.testingjava.badcode;

public class LegacyPaymentGateway {
    public static boolean charge(String customerId, double amount) {
        return amount < 500.0 && !customerId.isBlank();
    }
}
