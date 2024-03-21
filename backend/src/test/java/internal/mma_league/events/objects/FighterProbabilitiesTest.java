package internal.mma_league.events.objects;

import internal.mma_league.events.properties.BaseProbabilities;
import internal.mma_league.events.utils.FightProbabilityUtils;
import internal.mma_league.fighters.entity.Fighter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static internal.mma_league.events.utils.Formatting.twoDecimalRound;
import static org.junit.jupiter.api.Assertions.*;

class FighterProbabilitiesTest {

    @Test
    void testForAllEqualAttributes(){
        Fighter f1 = new Fighter.Builder("TEST", 155)
                .height(66)
                .birthday(LocalDate.now())
                .striking(50,50)
                .grappling(50,50)
                .build();

        OutcomeProbability op = BaseProbabilities.byWeightClass(155);
        FighterProbabilities probabilities = new FighterProbabilities(op, f1, f1);

        assertEquals(op.getKnockoutChancePerRound() / 2.0, probabilities.getFighter1KOChance());
        assertEquals(op.getKnockoutChancePerRound() / 2.0, probabilities.getFighter2KOChance());

        assertEquals(op.getSubmissionChancePerRound() / 2.0, probabilities.getFighter1SubChance());
        assertEquals(op.getSubmissionChancePerRound() / 2.0, probabilities.getFighter2SubChance());

        assertEquals(op.getNoFinishChance() / 2.0, probabilities.getFighter1NoFinishChance());
        assertEquals(op.getNoFinishChance() / 2.0, probabilities.getFighter2NoFinishChance());
    }

    @Test
    void testForMinMaxAttributes(){
        Fighter f1 = new Fighter.Builder("TEST", 155)
                .height(66)
                .birthday(LocalDate.now())
                .striking(100,100)
                .grappling(100,100)
                .build();
        Fighter f2 = new Fighter.Builder("TEST", 155)
                .height(66)
                .birthday(LocalDate.now())
                .striking(1,1)
                .grappling(1,1)
                .build();

        OutcomeProbability op = BaseProbabilities.byWeightClass(155);
        FighterProbabilities probabilities = new FighterProbabilities(op, f1, f2);

        assertEquals(twoDecimalRound(op.getKnockoutChancePerRound() + (op.getKnockoutChancePerRound() * .99)),
                probabilities.getFighter1KOChance());
        assertEquals(0.0, probabilities.getFighter2KOChance());

        assertEquals(twoDecimalRound(op.getSubmissionChancePerRound() + (op.getSubmissionChancePerRound() * .99)),
                probabilities.getFighter1SubChance());
        assertEquals(0.0, probabilities.getFighter2SubChance());

        double noFinChance = twoDecimalRound((1.0 - twoDecimalRound(op.getSubmissionChancePerRound() + (op.getSubmissionChancePerRound() * .99)) -
                twoDecimalRound(op.getKnockoutChancePerRound() + (op.getKnockoutChancePerRound() * .99))) * .99);

        assertEquals(noFinChance, probabilities.getFighter1NoFinishChance());
        assertEquals(0.01, probabilities.getFighter2NoFinishChance());
    }
}