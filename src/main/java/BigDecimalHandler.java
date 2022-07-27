import lombok.Getter;

import java.math.BigDecimal;

public class BigDecimalHandler {

    @Getter
    BigDecimal bigDecimal;

    BigDecimalHandler(String string) {
        try {
            bigDecimal = new BigDecimal(string);
            isValidValue();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input must be a value!");
        }
    }

    private void isValidValue() {
        BigDecimal wholeValue = bigDecimal.multiply(BigDecimal.valueOf(100));
        if (wholeValue.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) != 0)
            throw new IllegalArgumentException("Input must be a valid value (2 decimal places)!");
        else if (bigDecimal.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Input must be a positive value!");
    }
}
