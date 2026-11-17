package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
//Applies a rounding rule on ammounts for example 10.005 becomes 10.01
public final class MoneyRules {
    public static final int SCALE = 2;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private MoneyRules() {}

    public static BigDecimal round(BigDecimal amount) {
        return amount.setScale(SCALE, ROUNDING_MODE);
    }
}
