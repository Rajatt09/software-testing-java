package com.software.testingjava.module03_test_doubles;

import com.software.testingjava.domain.InvoiceProcessor;
import com.software.testingjava.domain.TaxService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ManualDoubleExerciseTest {

    // EXERCISE: Write a Stub (StubTaxService) to make this test pass, WITHOUT using Mockito.
    
    @Test
    @Disabled("Remove this to start the exercise")
    void shouldProcessInvoiceWithTax() {
        TaxService stubTaxService = null; // = new StubTaxService();
        InvoiceProcessor processor = new InvoiceProcessor(stubTaxService);
        
        BigDecimal total = processor.processInvoice("NY", new BigDecimal("100.00"));
        
        // Assert
        assertEquals(new BigDecimal("108.00"), total);
    }
    
    // Write your nested static StubTaxService class here
}
