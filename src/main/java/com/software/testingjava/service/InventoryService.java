package com.software.testingjava.service;

public interface InventoryService {
    boolean isAvailable(String sku, int quantity);

    void reserve(String sku, int quantity);
}
