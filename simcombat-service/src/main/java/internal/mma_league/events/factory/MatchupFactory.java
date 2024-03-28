package internal.mma_league.events.factory;

import internal.mma_league.events.entity.Matchup;
import internal.mma_league.events.enums.MatchupPriority;
import internal.mma_league.events.service.MatchupService;
import internal.mma_league.fighters.service.FighterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class MatchupFactory {

    private final FighterService fighterService;
    private final MatchupService matchupService;

    public List<Matchup> generate(MatchupPriority priority){
        return switch (priority){
            case MAIN_EVENT -> Collections.singletonList(generateMainEvent());
            case CO_MAIN_EVENT -> Collections.singletonList(generateCoMainEvent());
            case UNDER_CARD -> generateUndercard();
            case PRELIMS -> generatePrelims();
        };
    }

    private Matchup generateMainEvent(){

        return null;
    }

    private Matchup generateCoMainEvent(){

        return null;
    }

    private List<Matchup> generateUndercard(){

        return null;
    }

    private List<Matchup> generatePrelims(){

        return null;
    }
}
