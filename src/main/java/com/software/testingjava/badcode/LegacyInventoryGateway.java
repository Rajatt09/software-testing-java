package com.software.testingjava.badcode;

public class LegacyInventoryGateway {
    public boolean hasItem(String sku, int quantity) {
        return !"OUT-OF-STOCK".equals(sku) && quantity < 10;
    }
}
