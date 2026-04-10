package com.software.testingjava.badcode;

public class LegacyCheckoutManager {
    private final LegacyInventoryGateway inventoryGateway = new LegacyInventoryGateway();
    private final LegacyEmailSender emailSender = new LegacyEmailSender();

    public String checkout(String customerId, String email, String sku, int quantity, double pricePerItem) {
        LegacyAuditLogger.log("START:" + customerId);

        // Nasty static coupling making tests fail without DB context
        if (GlobalDatabaseConfig.isReadonly()) {
            return "SYSTEM_LOCKED";
        }

        if (customerId == null || customerId.isBlank()) {
            LegacyAuditLogger.log("INVALID_CUSTOMER");
            return "INVALID_CUSTOMER";
        }

        if (!inventoryGateway.hasItem(sku, quantity)) {
            LegacyAuditLogger.log("OUT_OF_STOCK");
            return "OUT_OF_STOCK";
        }

        double total = quantity * pricePerItem;
        boolean charged = LegacyPaymentGateway.charge(customerId, total);

        if (!charged) {
            LegacyAuditLogger.log("PAYMENT_FAILED");
            return "PAYMENT_FAILED";
        }

        emailSender.send("Order created for " + email);
        LegacyAuditLogger.log("SUCCESS:" + sku + ":" + total);
        return "SUCCESS";
    }
}
