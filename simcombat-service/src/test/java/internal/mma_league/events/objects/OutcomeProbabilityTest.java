package internal.mma_league.events.objects;

import internal.mma_league.events.exceptions.ProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutcomeProbabilityTest {

    private static final OutcomeProbability test1 =
            new OutcomeProbability(0.0, 0.0);
    private static final OutcomeProbability test2 =
            new OutcomeProbability(.5, .25);
    private static final OutcomeProbability test3 =
            new OutcomeProbability(1.5, 1.5);

    @Test
    void sumAlwaysEqualsOne(){
        assertEquals(1.0, test1.getKnockoutChancePerRound() +
                test1.getSubmissionChancePerRound() + test1.getNoFinishChance());
        assertEquals(1.0, test2.getKnockoutChancePerRound() +
                test2.getSubmissionChancePerRound() + test2.getNoFinishChance());
    }

    @Test
    void testOddsPerRound(){
        assertEquals(.0, test1.getKnockoutChancePerRound());
        assertEquals(.0, test1.getSubmissionChancePerRound());
        assertEquals(1.0, test1.getNoFinishChance());

        assertEquals(.17, test2.getKnockoutChancePerRound());
        assertEquals(.08, test2.getSubmissionChancePerRound());
        assertEquals(.75, test2.getNoFinishChance());

        assertEquals(.5, test3.getKnockoutChancePerRound());
        assertEquals(.5, test3.getSubmissionChancePerRound());
        assertEquals(.0, test3.getNoFinishChance());
    }

    @Test
    void sumLessThanOne(){
        assertThrows(ProbabilityException.class,
                () -> new OutcomeProbability(3.0, 3.0));
        assertThrows(ProbabilityException.class,
                () -> new OutcomeProbability(1.5, 1.8));
        assertDoesNotThrow(() -> new OutcomeProbability(0.0, 0.0));
        assertDoesNotThrow(() -> new OutcomeProbability(1.0, 1.0));
        assertDoesNotThrow(() -> new OutcomeProbability(1.5, 1.5));
    }
}