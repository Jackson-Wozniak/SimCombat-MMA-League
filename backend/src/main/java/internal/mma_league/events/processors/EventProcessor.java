package internal.mma_league.events.processors;

import internal.mma_league.events.entity.Event;
import internal.mma_league.events.entity.EventResult;
import internal.mma_league.events.entity.FightResult;
import internal.mma_league.fighters.service.FighterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventProcessor {

    private final FighterService fighterService;

    //order of fight simulation doesn't matter because order is only relevant client-side
    //this means that the simulation of matchups can be done in any order
    public EventResult simulateEvent(Event event){
        EventResult result = new EventResult(event.getName(), event.getDate());

        event.getMatchups().forEach(matchup -> {
            FightResult fight = FightProcessor.simulateFight(matchup);
            result.addFight(fight);

            //TODO: update ELO, Record, etc. for both Fighters
        });

        return result;
    }
}
