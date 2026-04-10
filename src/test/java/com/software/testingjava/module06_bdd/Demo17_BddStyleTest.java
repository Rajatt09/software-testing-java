package com.software.testingjava.module06_bdd;

import com.software.testingjava.external.EmailClient;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class Demo17_BddStyleTest {

    // DEMO: BDD Style Mockito
    // Regular Mockito uses `when(...).thenReturn(...)` and `verify(...)`. 
    // This breaks the Given/When/Then naming rhythm because 'when' acts as 'given'.
    // BDDMockito fixes this vocabulary clash.

    @Test
    void givenClient_whenSending_thenMessageDelivered() {
        // Given (Setup)
        EmailClient mockClient = mock(EmailClient.class);
        // Note the use of `given` instead of `when`
        // given(mockClient.isConnected()).willReturn(true); 
        
        // When (Action)
        mockClient.send("test@example.com", "Alert");
        
        // Then (Assertion)
        // Note the use of `then` instead of `verify`
        then(mockClient).should().send("test@example.com", "Alert");
    }
}
