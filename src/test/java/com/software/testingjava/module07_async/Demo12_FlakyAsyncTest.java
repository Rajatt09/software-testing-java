package com.software.testingjava.module07_async;
import com.software.testingjava.external.FlakyDataFetcher;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Demo12_FlakyAsyncTest {
    @Test
    void demo_flakyWithSleep() throws InterruptedException {
        FlakyDataFetcher fetcher = new FlakyDataFetcher();
        AtomicBoolean flag = new AtomicBoolean(false);
        
        fetcher.fetchDataAsync(() -> flag.set(true));
        
        // Guessed time. Run this multiple times and it occasionally crashes
        Thread.sleep(150); 
        
        assertTrue(flag.get());
    }
}
