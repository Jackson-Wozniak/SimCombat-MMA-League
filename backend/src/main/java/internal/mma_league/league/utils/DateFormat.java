package internal.mma_league.league.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFormat {

    public static String toWords(LocalDate date){
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int day = date.getDayOfMonth();
        int year = date.getYear();

        String ordinalIndicator = switch (day % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };

        return month + " " + day + ordinalIndicator + ", " + year;
    }
}
