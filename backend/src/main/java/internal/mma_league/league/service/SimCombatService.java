package internal.mma_league.league.service;

import internal.mma_league.league.entity.SimCombat;
import internal.mma_league.league.repository.SimCombatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SimCombatService {

    private final SimCombat simCombat;
    private final SimCombatRepository simCombatRepository;

    public LocalDate incrementDate(){
        simCombat.incrementDate();
        return simCombatRepository.save(simCombat).getDate();
    }
}
