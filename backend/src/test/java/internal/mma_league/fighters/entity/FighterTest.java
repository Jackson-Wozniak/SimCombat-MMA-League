package internal.mma_league.fighters.entity;

import internal.mma_league.fighters.enums.ChampionRank;
import internal.mma_league.fighters.enums.Discipline;
import internal.mma_league.fighters.enums.DisciplineLevel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FighterTest {

    @Test
    void testBuilder(){
        Fighter test = new Fighter.Builder("TEST", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .discipline(Discipline.MIXED_MARTIAL_ARTIST, DisciplineLevel.BEGINNER)
                .grade(99)
                .build();

        assertEquals("TEST", test.getName());
        assertEquals(155, test.getWeightClass());
        assertEquals(LocalDate.of(1, 1, 1), test.getBirthday());
        assertEquals(66, test.getHeightInInches());
        assertEquals(Discipline.MIXED_MARTIAL_ARTIST, test.getAttributes().getDiscipline());
        assertEquals(DisciplineLevel.BEGINNER, test.getAttributes().getDisciplineLevel());
        assertEquals(99, test.getAttributes().getGrade());
        assertEquals(ChampionRank.NON_RANKED, test.getStats().getChampionRank());
        assertEquals(1000, test.getStats().getElo());
        assertEquals(0, test.getStats().getFans());
        assertEquals(100, test.getStats().getLongevity());
        assertEquals(0, test.getStats().getLegacyScore());
        assertEquals(0, test.getStats().getRecord().getWins());
        assertEquals(0, test.getStats().getRecord().getLosses());
    }

    @Test
    void compareAllFourAttributes(){
        Fighter f1 = new Fighter.Builder("F1", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .discipline(Discipline.MIXED_MARTIAL_ARTIST, DisciplineLevel.BEGINNER)
                .grade(99)
                .build();

        Fighter f2 = new Fighter.Builder("F2", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .discipline(Discipline.MIXED_MARTIAL_ARTIST, DisciplineLevel.BEGINNER)
                .grade(99)
                .build();

        assertEquals(1, Fighter.myClassComparator.compare(f1, f2));

        f2.getStats().setElo(1001);
        assertEquals(-1, Fighter.myClassComparator.compare(f1, f2));

        f2.getStats().setElo(1000);
        assertEquals(1, Fighter.myClassComparator.compare(f1, f2));
        f2.getStats().getRecord().setWins(1);
        assertEquals(-1, Fighter.myClassComparator.compare(f1, f2));

        f2.getStats().getRecord().setWins(0);
        assertEquals(1, Fighter.myClassComparator.compare(f1, f2));
        f2.getStats().getRecord().setLosses(1);
        assertEquals(-1, Fighter.myClassComparator.compare(f1, f2));

        f2.getStats().getRecord().setLosses(0);
        assertEquals(1, Fighter.myClassComparator.compare(f1, f2));
        f2.getAttributes().setGrade(100);
        assertEquals(-1, Fighter.myClassComparator.compare(f1, f2));
    }
}