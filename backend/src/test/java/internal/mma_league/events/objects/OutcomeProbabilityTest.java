package internal.mma_league.events.objects;

import internal.mma_league.events.exceptions.ProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutcomeProbabilityTest {

    @Test
    void sumAlwaysEqualsOne(){
        OutcomeProbability test1 = new OutcomeProbability(0.0, 0.0);
        OutcomeProbability test2 = new OutcomeProbability(.5, .5);

        assertThrows(ProbabilityException.class,
                () -> new OutcomeProbability(.6, .505));

        assertEquals(1.0, test1.getKnockoutChancePerRound() +
                test1.getSubmissionChancePerRound() + test1.getNoFinishChance());
        assertEquals(1, test2.getKnockoutChancePerRound() +
                test2.getSubmissionChancePerRound() + test2.getNoFinishChance());
    }
}