package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.enums.FightingStyle;

import java.time.LocalDate;
import java.time.Period;

public class FighterUtils {

    public static String convertHeightToString(int inches){
        return (inches / 12) + "'" + (inches % 12) + "\"";
    }

    public static int calculateAgeInYears(LocalDate birthDate, LocalDate currentDate) {
        if (birthDate != null && currentDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static FightingStyle calculateFightingStyle(Fighter fighter){
        int sumOfStriking = fighter.getAttributes().getStrikingAbility()
                + fighter.getAttributes().getStrikingDefense();
        int sumOfGrappling = fighter.getAttributes().getGrapplingAbility()
                + fighter.getAttributes().getGrapplingDefense();

        if(sumOfStriking - sumOfGrappling > 25){
            return FightingStyle.STRIKER;
        }
        if(sumOfGrappling - sumOfStriking > 25){
            return FightingStyle.WRESTLER;
        }
        return FightingStyle.MIXED_MARTIAL_ARTIST;
    }
}
