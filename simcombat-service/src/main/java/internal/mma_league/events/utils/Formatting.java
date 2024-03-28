package internal.mma_league.events.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Formatting {

    public static double twoDecimalRound(double preRounded){
        BigDecimal bd = BigDecimal.valueOf(preRounded);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    public static double threeDecimalRound(double preRounded){
        BigDecimal bd = BigDecimal.valueOf(preRounded);
        bd = bd.setScale(3, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}
