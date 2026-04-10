package com.software.testingjava.module04_mockito;

import com.software.testingjava.domain.Customer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class Demo07_MockitoAntiPatternTest {
    @Test
    void demo_mockingValueObjectsIsBrittle() {
        Customer mockCustomer = mock(Customer.class);
        when(mockCustomer.getName()).thenReturn("Bob");
        when(mockCustomer.getEmail()).thenReturn("bob@example.com");
        when(mockCustomer.isPremiumMember()).thenReturn(true);
        
        // The above is painful. Always do this instead:
        // Customer realCustomer = new Customer("1", "Bob", "bob@example.com", true);
    }
}
