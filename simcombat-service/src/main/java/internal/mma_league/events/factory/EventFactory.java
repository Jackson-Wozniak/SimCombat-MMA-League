package internal.mma_league.events.factory;

import internal.mma_league.events.entity.Event;
import internal.mma_league.events.enums.MatchupPriority;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class EventFactory {

    private final MatchupFactory matchupFactory;

    public Event generate(String name, LocalDate date){
        return new Event.Builder(name, date)
                .mainEvent(matchupFactory.generate(MatchupPriority.MAIN_EVENT).get(0))
                .coMainEvent(matchupFactory.generate(MatchupPriority.CO_MAIN_EVENT).get(0))
                .undercard(matchupFactory.generate(MatchupPriority.UNDER_CARD))
                .prelims(matchupFactory.generate(MatchupPriority.PRELIMS))
                .build();
    }
}
