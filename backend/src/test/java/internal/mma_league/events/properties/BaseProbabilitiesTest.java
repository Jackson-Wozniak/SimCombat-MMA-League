package internal.mma_league.events.properties;

import internal.mma_league.events.objects.OutcomeProbability;
import internal.mma_league.fighters.enums.WeightClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseProbabilitiesTest {

    @Test
    void testWeightClassProbabilities(){
        OutcomeProbability op = BaseProbabilities.byWeightClass(WeightClass.FLYWEIGHT);
        assertEquals(.08, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.85, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.BANTAMWEIGHT);
        assertEquals(.09, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.84, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.FEATHERWEIGHT);
        assertEquals(.09, op.getKnockoutChancePerRound());
        assertEquals(.06, op.getSubmissionChancePerRound());
        assertEquals(.85, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.LIGHTWEIGHT);
        assertEquals(.1, op.getKnockoutChancePerRound());
        assertEquals(.08, op.getSubmissionChancePerRound());
        assertEquals(.82, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.WELTERWEIGHT);
        assertEquals(.11, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.82, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.MIDDLEWEIGHT);
        assertEquals(.12, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.81, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.LIGHT_HEAVYWEIGHT);
        assertEquals(.14, op.getKnockoutChancePerRound());
        assertEquals(.06, op.getSubmissionChancePerRound());
        assertEquals(.80, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClass.HEAVYWEIGHT);
        assertEquals(.16, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.77, op.getNoFinishChance());
    }

}