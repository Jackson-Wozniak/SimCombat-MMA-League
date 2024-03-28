package internal.mma_league.league.payload;

import internal.mma_league.league.entity.SimCombat;
import internal.mma_league.league.utils.DateFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SimCombatDTO {

    private String date;
    private int eventsScheduled;
    private List<String> events;

    public SimCombatDTO(SimCombat simCombat, Map<String, LocalDate> events){
        this.date = DateFormat.toWords(simCombat.getDate());
        this.eventsScheduled = events.size();
        this.events = events.entrySet().stream()
                .map(event -> event.getKey() + " on " + DateFormat.toWords(event.getValue()))
                .toList();
    }
}
