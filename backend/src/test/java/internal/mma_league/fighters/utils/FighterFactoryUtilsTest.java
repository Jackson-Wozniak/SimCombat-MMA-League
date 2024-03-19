package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.exception.InvalidWeightClassException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterFactoryUtilsTest {

    @Test
    void withinBaseRangeHeight(){
        for(int i = 0; i < 1000; i++){
            //base height for 155 is 67 inches, and 73 should be max height
            int height = FighterFactoryUtils.randomHeightInches(155);
            assertTrue(height <= 73 && height >= 67);
        }
    }

    @Test
    void onlyValidWeightClasses(){
        assertThrows(InvalidWeightClassException.class,
                () -> FighterFactoryUtils.randomHeightInches(100));
        assertThrows(InvalidWeightClassException.class,
                () -> FighterFactoryUtils.randomHeightInches(0));
        assertThrows(InvalidWeightClassException.class,
                () -> FighterFactoryUtils.randomHeightInches(154));
        assertThrows(InvalidWeightClassException.class,
                () -> FighterFactoryUtils.randomHeightInches(186));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(125));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(135));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(145));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(155));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(170));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(185));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(205));
        assertDoesNotThrow(() -> FighterFactoryUtils.randomHeightInches(265));
    }
}