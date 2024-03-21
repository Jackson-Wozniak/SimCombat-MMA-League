package internal.mma_league.events.repository;

import internal.mma_league.events.entity.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchupRepository extends JpaRepository<Matchup, Long> {
}
