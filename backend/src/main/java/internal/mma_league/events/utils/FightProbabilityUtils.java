package internal.mma_league.events.utils;

import internal.mma_league.events.objects.FighterProbabilities;
import internal.mma_league.events.objects.OutcomeProbability;
import internal.mma_league.events.properties.BaseProbabilities;
import internal.mma_league.fighters.entity.Fighter;

import java.util.Random;

public class FightProbabilityUtils {

    private static final Random random = new Random();

    public static FighterProbabilities generateFighterProbabilities(int weight, Fighter f1, Fighter f2){
        OutcomeProbability outcomeProbability = BaseProbabilities.byWeightClass(weight);
        return new FighterProbabilities(outcomeProbability, f1, f2);
    }
}
