package internal.mma_league.fighters.payload;

import internal.mma_league.events.enums.Outcome;
import internal.mma_league.fighters.entity.Fighter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FighterDTOTest {

    @Test
    void testDTOMapper(){
        Fighter fighter = new Fighter.Builder("F1", 155)
                .height(66)
                .birthday(LocalDate.now().minusYears(20).plusDays(180))
                .striking(100, 100)
                .grappling(100, 100)
                .build();
        fighter.incrementRecord(true, Outcome.DECISION);
        fighter.incrementRecord(true, Outcome.DECISION);
        fighter.incrementRecord(false, Outcome.DECISION);

        FighterDTO fighterDTO = new FighterDTO(fighter);

        assertEquals("LIGHTWEIGHT", fighterDTO.getWeightClass());
        assertEquals("5'6\"", fighterDTO.getHeight());
        assertEquals(19, fighterDTO.getAge());
        assertEquals("2-1", fighterDTO.getRecord());
        assertEquals("Mixed Martial Artist", fighterDTO.getFightingStyle());
    }
}