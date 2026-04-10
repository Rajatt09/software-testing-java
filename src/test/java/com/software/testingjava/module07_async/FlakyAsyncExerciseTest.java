package com.software.testingjava.module07_async;

import com.software.testingjava.external.FlakyDataFetcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

class FlakyAsyncExerciseTest {

    // EXERCISE: This test relies on Thread.sleep(), which makes it flaky. 
    // Run it a few times - it might fail.
    // Refactor it to use Awaitility, a CountDownLatch, or CompletableFuture.

    @Test
    @Disabled("Remove this to start the exercise")
    void testAsyncFetch() throws InterruptedException {
        FlakyDataFetcher fetcher = new FlakyDataFetcher();
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        
        fetcher.fetchDataAsync(() -> wasCalled.set(true));
        
        // FLAKY: We are guessing it will finish in 150ms.
        Thread.sleep(150);
        
        assertTrue(wasCalled.get(), "Callback should have been executed");
    }
}
