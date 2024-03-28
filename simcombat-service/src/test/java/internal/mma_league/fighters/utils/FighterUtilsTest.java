package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.enums.FightingStyle;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FighterUtilsTest {

    @Test
    void convertHeightToString() {
        for(int i = 0; i < 12; i++){
            String height = "1'" + i + "\"";
            assertEquals(height, FighterUtils.convertHeightToString(12 + i));
        }

        for(int i = 0; i < 12; i++){
            String height = "5'" + i + "\"";
            assertEquals(height, FighterUtils.convertHeightToString(60 + i));
        }

        assertEquals("0'0\"", FighterUtils.convertHeightToString(0));
    }

    @Test
    void calculateAgeInYears() {
        LocalDate today = LocalDate.of(2024, 6, 1);

        LocalDate birthday1 = LocalDate.of(2024, 6, 1);
        LocalDate birthday2 = LocalDate.of(2004, 6, 2);
        LocalDate birthday3 = LocalDate.of(2004, 1, 1);
        LocalDate birthday4 = LocalDate.of(2000, 7, 25);
        LocalDate birthday5 = LocalDate.of(2000, 5, 25);

        assertEquals(0, FighterUtils.calculateAgeInYears(birthday1, today));
        assertEquals(19, FighterUtils.calculateAgeInYears(birthday2, today));
        assertEquals(20, FighterUtils.calculateAgeInYears(birthday3, today));
        assertEquals(23, FighterUtils.calculateAgeInYears(birthday4, today));
        assertEquals(24, FighterUtils.calculateAgeInYears(birthday5, today));
        assertEquals(0, FighterUtils.calculateAgeInYears(null, today));
        assertEquals(0, FighterUtils.calculateAgeInYears(null, null));
        assertEquals(0, FighterUtils.calculateAgeInYears(birthday4, null));
    }

    @Test
    void calculateFightingStyle(){
        Fighter f1 = new Fighter.Builder("T", 155)
                .striking(100, 100)
                .grappling(0, 0)
                .birthday(LocalDate.now())
                .height(70)
                .build();
        Fighter f2 = new Fighter.Builder("T", 155)
                .striking(0, 0)
                .grappling(100, 100)
                .birthday(LocalDate.now())
                .height(70)
                .build();
        Fighter f3 = new Fighter.Builder("T", 155)
                .striking(50, 50)
                .grappling(50, 50)
                .birthday(LocalDate.now())
                .height(70)
                .build();

        assertEquals(FightingStyle.STRIKER, FighterUtils.calculateFightingStyle(f1));
        assertEquals(FightingStyle.WRESTLER, FighterUtils.calculateFightingStyle(f2));
        assertEquals(FightingStyle.MIXED_MARTIAL_ARTIST, FighterUtils.calculateFightingStyle(f3));
    }
}