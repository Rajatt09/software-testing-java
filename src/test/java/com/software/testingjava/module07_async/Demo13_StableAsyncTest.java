package com.software.testingjava.module07_async;

import com.software.testingjava.external.FlakyDataFetcher;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Demo13_StableAsyncTest {
    @Test
    void demo_stableWithLatch() throws InterruptedException {
        FlakyDataFetcher fetcher = new FlakyDataFetcher();
        CountDownLatch latch = new CountDownLatch(1);
        
        fetcher.fetchDataAsync(latch::countDown);
        
        // Implicitly waits UP TO 1 second, but fails precisely if exceeded.
        boolean completed = latch.await(1, TimeUnit.SECONDS);
        assertTrue(completed);
    }
}
