package internal.mma_league.events.utils;

import internal.mma_league.events.properties.BaseProbabilities;
import internal.mma_league.fighters.entity.Fighter;

import java.text.DecimalFormat;

public class WinProbabilityUtils {

    private static final DecimalFormat formatter = new DecimalFormat("0.##");

    public static double fighter1WinProbability(Fighter fighter1, Fighter fighter2){
        int fighter1Offense = fighter1.getAttributes().getGrapplingAbility()
                + fighter1.getAttributes().getStrikingAbility();
        int fighter1Defense = fighter1.getAttributes().getGrapplingDefense()
                + fighter1.getAttributes().getStrikingDefense();
        int fighter2Offense = fighter2.getAttributes().getGrapplingAbility()
                + fighter2.getAttributes().getStrikingAbility();
        int fighter2Defense = fighter2.getAttributes().getGrapplingDefense()
                + fighter2.getAttributes().getStrikingDefense();

        double fighter1WeightedGrade = (BaseProbabilities.abilityWeight * fighter1Offense) +
                (BaseProbabilities.defenseWeight * fighter1Defense);
        double fighter2WeightedGrade = (BaseProbabilities.abilityWeight * fighter2Offense) +
                (BaseProbabilities.defenseWeight * fighter2Defense);

        double totalWeightedGrade = fighter1WeightedGrade + fighter2WeightedGrade;

        return format(fighter1WeightedGrade / totalWeightedGrade);
    }

    private static double format(double d){
        return Double.parseDouble(formatter.format(d));
    }
}
