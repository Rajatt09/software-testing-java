package com.software.testingjava.external;

public class FlakyDataFetcher {
    public void fetchDataAsync(Runnable callback) {
        new Thread(() -> {
            try {
                // Simulates a variable network delay (100ms - 400ms)
                Thread.sleep((long) (100 + Math.random() * 300));
                callback.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
