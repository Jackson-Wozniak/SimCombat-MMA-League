package internal.mma_league.events.utils;

import internal.mma_league.fighters.entity.Fighter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WinProbabilityUtilsTest {

    @Test
    void testWinProbs(){
        Fighter fighter1 = new Fighter.Builder("TEST", 155)
                .birthday(LocalDate.now())
                .height(66)
                .striking(100, 100)
                .grappling(100, 100)
                .build();
        Fighter fighter2 = new Fighter.Builder("TEST", 155)
                .birthday(LocalDate.now())
                .height(66)
                .striking(1, 1)
                .grappling(1, 1)
                .build();
        Fighter fighter3 = new Fighter.Builder("TEST", 155)
                .birthday(LocalDate.now())
                .height(66)
                .striking(50, 50)
                .grappling(50, 50)
                .build();
        Fighter fighter4 = new Fighter.Builder("TEST", 155)
                .birthday(LocalDate.now())
                .height(66)
                .striking(25, 25)
                .grappling(25, 25)
                .build();
        Fighter fighter5 = new Fighter.Builder("TEST", 155)
                .birthday(LocalDate.now())
                .height(66)
                .striking(75, 75)
                .grappling(75, 75)
                .build();

        assertEquals(.5, WinProbabilityUtils.fighter1WinProbability(fighter1, fighter1));
        assertEquals(.99, WinProbabilityUtils.fighter1WinProbability(fighter1, fighter2));
        assertEquals(.67, WinProbabilityUtils.fighter1WinProbability(fighter1, fighter3));
        assertEquals(.33, WinProbabilityUtils.fighter1WinProbability(fighter3, fighter1));
        assertEquals(.25, WinProbabilityUtils.fighter1WinProbability(fighter4, fighter5));
    }
}