package com.software.testingjava.domain;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static class CartItem {
        String sku;
        int quantity;

        CartItem(String sku, int quantity) {
            this.sku = sku;
            this.quantity = quantity;
        }
    }

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(String sku, int quantity) {
        for (CartItem item : items) {
            if (item.sku.equals(sku)) {
                item.quantity += quantity;
                return;
            }
        }
        items.add(new CartItem(sku, quantity));
    }

    public int getTotalQuantity() {
        int total = 0;
        for (CartItem item : items) {
            total += item.quantity;
        }
        return total;
    }

    public boolean containsItem(String sku) {
        for (CartItem item : items) {
            if (item.sku.equals(sku)) {
                return true;
            }
        }
        return false;
    }
}
