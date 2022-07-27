import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class CalculatorTest {

    @Test
    void CalculateAndRound_WholeValue_ReturnsCorrectAnswer() {
        Assertions.assertEquals(Calculator.calculateAndRound("42020.0", BigDecimal.valueOf(0.85141)), "35776,25");
    }

    @Test
    void CalculateAndRound_FractionalValue_ReturnsCorrectAnswer() {
        Assertions.assertEquals(Calculator.calculateAndRound("321521.23", BigDecimal.valueOf(0.85141)), "273746,39");
    }

    @Test
    void CalculateAndRound_BigValue_ReturnsCorrectAnswer() {
        Assertions.assertEquals(Calculator.calculateAndRound("999555999555.31", BigDecimal.valueOf(15275.69)), "15268907586847053,41");
    }

    @Test
    void CalculateAndRound_WrongFractionalValue_ThrowsException() {
        IllegalArgumentException thrown = Assertions
                .assertThrows(IllegalArgumentException.class, () -> {
                    Calculator.calculateAndRound("23232.001", BigDecimal.valueOf(0.85141));
                });
        Assertions.assertEquals("Input must be a valid value (2 decimal places)!", thrown.getMessage());
        // you can't have less than 0.01 EUR (physically)
    }

    @Test
    void CalculateAndRound_NegativeValue_ThrowsException() {
        IllegalArgumentException thrown = Assertions
                .assertThrows(IllegalArgumentException.class, () -> {
                    Calculator.calculateAndRound("-23232.2", BigDecimal.valueOf(0.85141));
                });
        Assertions.assertEquals("Input must be a positive value!", thrown.getMessage());
    }

    @Test
    void CalculateAndRound_NotValue_ThrowsException() {
        NumberFormatException thrown = Assertions
                .assertThrows(NumberFormatException.class, () -> {
                    Calculator.calculateAndRound("abc", BigDecimal.valueOf(0.85141));
                });
        Assertions.assertEquals("Input must be a value!", thrown.getMessage());
    }
}
