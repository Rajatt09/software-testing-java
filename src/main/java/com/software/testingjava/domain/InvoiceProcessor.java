package com.software.testingjava.domain;
import java.math.BigDecimal;

public class InvoiceProcessor {
    private final TaxService taxService;
    
    public InvoiceProcessor(TaxService taxService) {
        this.taxService = taxService;
    }
    
    public BigDecimal processInvoice(String regionCode, BigDecimal baseAmount) {
        BigDecimal tax = taxService.calculateTax(regionCode, baseAmount);
        return baseAmount.add(tax);
    }
}
