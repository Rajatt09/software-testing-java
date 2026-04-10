package com.software.testingjava.module03_test_doubles;

import com.software.testingjava.service.InMemoryInventoryService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Demo08_StateWithFakeTest {

    @Test
    void demo_fakeStateVerification() {
        InMemoryInventoryService fake = new InMemoryInventoryService();
        fake.addStock("BOOK", 1);

        fake.reserve("BOOK", 1);
        
        // Verify STATE, not interactions. Highly robust to refactoring.
        assertTrue(fake.isAvailable("BOOK", 0)); // No more books left
    }

}
