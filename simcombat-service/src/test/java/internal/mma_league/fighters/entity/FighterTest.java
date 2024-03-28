package internal.mma_league.fighters.entity;

import internal.mma_league.events.enums.Outcome;
import internal.mma_league.fighters.enums.ChampionRank;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FighterTest {

    @Test
    void testBuilder(){
        Fighter test = new Fighter.Builder("TEST", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .striking(100, 100)
                .grappling(99, 99)
                .build();

        assertEquals("TEST", test.getName());
        assertEquals(155, test.getWeightClass());
        assertEquals(LocalDate.of(1, 1, 1), test.getBirthday());
        assertEquals(66, test.getHeightInInches());
        assertEquals(100, test.getAttributes().getStrikingAbility());
        assertEquals(99, test.getAttributes().getGrapplingAbility());
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
                .striking(100, 100)
                .grappling(100, 100)
                .build();

        Fighter f2 = new Fighter.Builder("F2", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .striking(100, 100)
                .grappling(100, 100)
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
        f1.getAttributes().setGrapplingAbility(50);
        assertEquals(-1, Fighter.myClassComparator.compare(f1, f2));
    }

    @Test
    void incremementRecord(){
        Fighter fighter = new Fighter.Builder("F1", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .striking(100, 100)
                .grappling(100, 100)
                .build();
        FighterRecord record = fighter.getStats().getRecord();
        assertEquals(0, record.getWins());
        assertEquals(0, record.getLosses());
        assertEquals(0, record.getKnockouts());
        assertEquals(0, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(true, Outcome.KNOCKOUT);
        assertEquals(1, record.getWins());
        assertEquals(0, record.getLosses());
        assertEquals(1, record.getKnockouts());
        assertEquals(0, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(true, Outcome.KNOCKOUT);
        assertEquals(2, record.getWins());
        assertEquals(0, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(0, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(true, Outcome.SUBMISSION);
        assertEquals(3, record.getWins());
        assertEquals(0, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(1, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(true, Outcome.DECISION);
        assertEquals(4, record.getWins());
        assertEquals(0, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(1, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(false, Outcome.DECISION);
        assertEquals(4, record.getWins());
        assertEquals(1, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(1, record.getSubmissions());
        assertEquals(0, record.getTimesFinished());

        fighter.incrementRecord(false, Outcome.KNOCKOUT);
        assertEquals(4, record.getWins());
        assertEquals(2, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(1, record.getSubmissions());
        assertEquals(1, record.getTimesFinished());

        fighter.incrementRecord(false, Outcome.SUBMISSION);
        assertEquals(4, record.getWins());
        assertEquals(3, record.getLosses());
        assertEquals(2, record.getKnockouts());
        assertEquals(1, record.getSubmissions());
        assertEquals(2, record.getTimesFinished());
    }

    @Test
    void getFormattedRecord(){
        Fighter fighter = new Fighter.Builder("F1", 155)
                .height(66)
                .birthday(LocalDate.of(1, 1, 1))
                .striking(100, 100)
                .grappling(100, 100)
                .build();

        assertEquals("0-0", fighter.getFormattedRecord());

        for(int i = 1; i < 100; i++){
            fighter.incrementRecord(true, Outcome.DECISION);
            assertEquals(i + "-" + (i - 1), fighter.getFormattedRecord());

            fighter.incrementRecord(false, Outcome.DECISION);
            assertEquals(i + "-" + i, fighter.getFormattedRecord());
        }
    }
}