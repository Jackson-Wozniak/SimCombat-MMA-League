package internal.mma_league.fighters.repository;

import internal.mma_league.fighters.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, String> {
}
