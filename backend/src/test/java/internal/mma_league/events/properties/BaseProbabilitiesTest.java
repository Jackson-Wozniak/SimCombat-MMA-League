package internal.mma_league.events.properties;

import internal.mma_league.events.objects.OutcomeProbability;
import internal.mma_league.league.enums.WeightClassNames;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseProbabilitiesTest {

    @Test
    void testWeightClassProbabilities(){
        OutcomeProbability op = BaseProbabilities.byWeightClass(WeightClassNames.FLYWEIGHT);
        assertEquals(.08, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.85, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.BANTAMWEIGHT);
        assertEquals(.09, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.84, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.FEATHERWEIGHT);
        assertEquals(.09, op.getKnockoutChancePerRound());
        assertEquals(.06, op.getSubmissionChancePerRound());
        assertEquals(.85, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.LIGHTWEIGHT);
        assertEquals(.1, op.getKnockoutChancePerRound());
        assertEquals(.08, op.getSubmissionChancePerRound());
        assertEquals(.82, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.WELTERWEIGHT);
        assertEquals(.11, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.82, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.MIDDLEWEIGHT);
        assertEquals(.12, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.81, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.LIGHT_HEAVYWEIGHT);
        assertEquals(.14, op.getKnockoutChancePerRound());
        assertEquals(.06, op.getSubmissionChancePerRound());
        assertEquals(.80, op.getNoFinishChance());

        op = BaseProbabilities.byWeightClass(WeightClassNames.HEAVYWEIGHT);
        assertEquals(.16, op.getKnockoutChancePerRound());
        assertEquals(.07, op.getSubmissionChancePerRound());
        assertEquals(.77, op.getNoFinishChance());
    }

}