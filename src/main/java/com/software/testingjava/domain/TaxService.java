package com.software.testingjava.domain;
import java.math.BigDecimal;

public interface TaxService {
    BigDecimal calculateTax(String regionCode, BigDecimal amount);
}
