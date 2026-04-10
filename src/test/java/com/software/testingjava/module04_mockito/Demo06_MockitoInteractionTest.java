package com.software.testingjava.module04_mockito;

import com.software.testingjava.external.EmailClient;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class Demo06_MockitoInteractionTest {
    @Test
    void demo_verifySystemBoundary() {
        EmailClient mockClient = mock(EmailClient.class);
        
        // Act
        mockClient.send("test@example.com", "Hello");

        // Assert: We care about the interaction occurring, not the return value
        verify(mockClient).send("test@example.com", "Hello");
    }
}
