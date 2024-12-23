
package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyUtilsTest {

    @Test
    void testConvertUsdToIdrValid() {
        assertEquals(150000.0, CurrencyUtils.convertUsdToIdr(10.0), 0.01);
        assertEquals(75000.0, CurrencyUtils.convertUsdToIdr(5.0), 0.01);
        assertEquals(0.0, CurrencyUtils.convertUsdToIdr(0.0), 0.01);
    }

    @Test
    void testConvertUsdToIdrNegativeValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CurrencyUtils.convertUsdToIdr(-10.0);
        });
        assertEquals("Amount in USD cannot be negative.", exception.getMessage());
    }
}
