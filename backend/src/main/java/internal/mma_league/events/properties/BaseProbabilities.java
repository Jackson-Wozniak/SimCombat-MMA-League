package internal.mma_league.events.properties;

import internal.mma_league.events.objects.OutcomeProbability;
import internal.mma_league.fighters.enums.WeightClass;

public class BaseProbabilities {

    public static final double abilityWeight = .6;
    public static final double defenseWeight = .4;

    private static final OutcomeProbability flyweightProbabilities =
            new OutcomeProbability(.24, .22);
    private static final OutcomeProbability bantamweightProbabilities =
            new OutcomeProbability(.28, .20);
    private static final OutcomeProbability featherweightProbabilities =
            new OutcomeProbability(.27, .17);
    private static final OutcomeProbability lightweightProbabilities =
            new OutcomeProbability(.29, .23);
    private static final OutcomeProbability welterweightProbabilities =
            new OutcomeProbability(.32, .20);
    private static final OutcomeProbability middleweightProbabilities =
            new OutcomeProbability(.37, .22);
    private static final OutcomeProbability lhwProbabilities =
            new OutcomeProbability(.43, .19);
    private static final OutcomeProbability heavyweightProbabilities =
            new OutcomeProbability(.49, .22);

    public static OutcomeProbability byWeightClass(WeightClass weightClass){
        return switch (weightClass){
            case FLYWEIGHT -> flyweightProbabilities;
            case BANTAMWEIGHT -> bantamweightProbabilities;
            case FEATHERWEIGHT -> featherweightProbabilities;
            case LIGHTWEIGHT -> lightweightProbabilities;
            case WELTERWEIGHT -> welterweightProbabilities;
            case MIDDLEWEIGHT -> middleweightProbabilities;
            case LIGHT_HEAVYWEIGHT -> lhwProbabilities;
            case HEAVYWEIGHT -> heavyweightProbabilities;
        };
    }
}
