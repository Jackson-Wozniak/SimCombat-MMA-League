package internal.mma_league.events.repository;

import internal.mma_league.events.entity.EventResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventResultRepository extends JpaRepository<EventResult, String> {
}
