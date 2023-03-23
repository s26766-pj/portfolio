package Functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Round(double value, int precision) {
    public static double getRound(double value, int precision) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}