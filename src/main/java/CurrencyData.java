import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyData {

    @Getter
    private final Map<String, BigDecimal> currencyExchange;

    CurrencyData(Map map) {
        this.currencyExchange = map;
    }

    @Override
    public String toString() {
        return "currencyExchange=" + currencyExchange +
                '}';
    }
}
