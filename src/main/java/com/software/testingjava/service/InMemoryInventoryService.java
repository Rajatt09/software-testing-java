package com.software.testingjava.service;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryService implements InventoryService {
    private final Map<String, Integer> stockBySku = new HashMap<>();

    public void addStock(String sku, int quantity) {
        stockBySku.put(sku, stockBySku.getOrDefault(sku, 0) + quantity);
    }

    @Override
    public boolean isAvailable(String sku, int quantity) {
        return stockBySku.getOrDefault(sku, 0) >= quantity;
    }

    @Override
    public void reserve(String sku, int quantity) {
        if (!isAvailable(sku, quantity)) {
            throw new IllegalStateException("Cannot reserve unavailable stock");
        }

        stockBySku.put(sku, stockBySku.get(sku) - quantity);
    }
}
