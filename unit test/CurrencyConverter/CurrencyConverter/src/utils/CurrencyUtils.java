
package utils;

public class CurrencyUtils {

    private static final double EXCHANGE_RATE = 15000;

    public static double convertUsdToIdr(double usd) {
        if (usd < 0) {
            throw new IllegalArgumentException("Amount in USD cannot be negative.");
        }
        return usd * EXCHANGE_RATE;
    }
}
