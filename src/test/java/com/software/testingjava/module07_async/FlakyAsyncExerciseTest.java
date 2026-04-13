package com.software.testingjava.module07_async;

import com.software.testingjava.external.FlakyDataFetcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class FlakyAsyncExerciseTest {

    // EXERCISE: This test relies on Thread.sleep(), which makes it flaky. 
    // Run it a few times - it might fail.
    // Refactor it to use Awaitility, a CountDownLatch, or CompletableFuture.

    @Test
//    @Disabled("Remove this to start the exercise")
    void testAsyncFetch() throws InterruptedException {
        FlakyDataFetcher fetcher = new FlakyDataFetcher();
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        CountDownLatch latch = new CountDownLatch(1);

//        fetcher.fetchDataAsync(() -> wasCalled.set(true));

        fetcher.fetchDataAsync(() -> {
            wasCalled.set(true);
            latch.countDown();
        });
        
        // FLAKY: We are guessing it will finish in 150ms.
//        Thread.sleep(150);

        boolean completed = latch.await(1, TimeUnit.SECONDS);

        assertTrue(completed);
        assertTrue(wasCalled.get(), "Callback should have been executed");
    }
}
