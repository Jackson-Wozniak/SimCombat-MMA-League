package internal.mma_league.fighters.payload;

import internal.mma_league.fighters.entity.Fighter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FighterSummaryDTO {

    private final String name;
    private final int ranking;
    private final String record;

    public FighterSummaryDTO(Fighter fighter, int ranking){
        this.name = fighter.getName();
        this.record = fighter.getFormattedRecord();
        this.ranking = (ranking < 13 ? ranking : -1); //only rank top 12
    }
}
