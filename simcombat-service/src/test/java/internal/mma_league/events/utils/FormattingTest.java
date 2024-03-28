package internal.mma_league.events.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormattingTest {

    @Test
    void twoDecimalRound() {
        assertEquals(0.00, Formatting.twoDecimalRound(0.000));
        assertEquals(0.00, Formatting.twoDecimalRound(0.001));
        assertEquals(0.00, Formatting.twoDecimalRound(0.002));
        assertEquals(0.00, Formatting.twoDecimalRound(0.003));
        assertEquals(0.00, Formatting.twoDecimalRound(0.004));
        assertEquals(0.01, Formatting.twoDecimalRound(0.005));
        assertEquals(0.01, Formatting.twoDecimalRound(0.006));
        assertEquals(0.01, Formatting.twoDecimalRound(0.007));
        assertEquals(0.01, Formatting.twoDecimalRound(0.008));
        assertEquals(0.01, Formatting.twoDecimalRound(0.009));

        assertEquals(10.65, Formatting.twoDecimalRound(10.650));
        assertEquals(10.65, Formatting.twoDecimalRound(10.651));
        assertEquals(10.65, Formatting.twoDecimalRound(10.652));
        assertEquals(10.65, Formatting.twoDecimalRound(10.653));
        assertEquals(10.65, Formatting.twoDecimalRound(10.654));
        assertEquals(10.66, Formatting.twoDecimalRound(10.655));
        assertEquals(10.66, Formatting.twoDecimalRound(10.656));
        assertEquals(10.66, Formatting.twoDecimalRound(10.657));
        assertEquals(10.66, Formatting.twoDecimalRound(10.658));
        assertEquals(10.66, Formatting.twoDecimalRound(10.659));
    }

    @Test
    void threeDecimalRound() {
        assertEquals(0.000, Formatting.threeDecimalRound(0.0000));
        assertEquals(0.000, Formatting.threeDecimalRound(0.0001));
        assertEquals(0.000, Formatting.threeDecimalRound(0.0002));
        assertEquals(0.000, Formatting.threeDecimalRound(0.0003));
        assertEquals(0.000, Formatting.threeDecimalRound(0.0004));
        assertEquals(0.001, Formatting.threeDecimalRound(0.0005));
        assertEquals(0.001, Formatting.threeDecimalRound(0.0006));
        assertEquals(0.001, Formatting.threeDecimalRound(0.0007));
        assertEquals(0.001, Formatting.threeDecimalRound(0.0008));
        assertEquals(0.001, Formatting.threeDecimalRound(0.0009));

        assertEquals(10.655, Formatting.threeDecimalRound(10.6550));
        assertEquals(10.655, Formatting.threeDecimalRound(10.6551));
        assertEquals(10.655, Formatting.threeDecimalRound(10.6552));
        assertEquals(10.655, Formatting.threeDecimalRound(10.6553));
        assertEquals(10.655, Formatting.threeDecimalRound(10.6554));
        assertEquals(10.656, Formatting.threeDecimalRound(10.6555));
        assertEquals(10.656, Formatting.threeDecimalRound(10.6556));
        assertEquals(10.656, Formatting.threeDecimalRound(10.6557));
        assertEquals(10.656, Formatting.threeDecimalRound(10.6558));
        assertEquals(10.656, Formatting.threeDecimalRound(10.6559));
    }
}