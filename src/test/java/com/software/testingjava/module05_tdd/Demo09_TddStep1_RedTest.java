package com.software.testingjava.module05_tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Demo09_TddStep1_RedTest {
    @Test
    void shouldReturnFizzOnThree() {
        // Red: Test doesn't even compile originally, 
        // or throws UnsupportedOperationException
        // String result = FizzBuzz.evaluate(3);
        // assertEquals("Fizz", result);
    }
}
