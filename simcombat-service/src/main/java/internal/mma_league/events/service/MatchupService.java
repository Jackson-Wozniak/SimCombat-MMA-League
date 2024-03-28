package internal.mma_league.events.service;

import internal.mma_league.events.repository.MatchupRepository;
import internal.mma_league.fighters.entity.Fighter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchupService {

    private final MatchupRepository matchupRepository;

    public boolean hasScheduledMatchup(Fighter fighter){
        return !matchupRepository.findAll().stream()
                .filter(matchup -> matchup.getFighter1().equals(fighter) ||
                        matchup.getFighter2().equals(fighter))
                .toList()
                .isEmpty();
    }
}
