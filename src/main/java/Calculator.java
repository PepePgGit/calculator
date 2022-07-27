import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculator {

    private static final DecimalFormat dfSharp = new DecimalFormat("#.##");

    private static String roundValue(BigDecimal value) {
        dfSharp.setRoundingMode(RoundingMode.HALF_UP);
        return dfSharp.format(value);
    }

    public static String calculateAndRound(String euros, BigDecimal exchangeRate) {
        BigDecimalHandler bigDecimalHandler = new BigDecimalHandler(euros);
        return roundValue(bigDecimalHandler.getBigDecimal().multiply(exchangeRate));
    }
}
