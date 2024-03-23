package internal.mma_league.league.payload;

import internal.mma_league.fighters.payload.FighterSummaryDTO;
import internal.mma_league.league.entity.WeightClass;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class WeightClassDTO {

    private final String weight;
    private final Set<FighterSummaryDTO> fighters;

    public WeightClassDTO(WeightClass weightClass){
        this.weight = weightClass.getName();
        this.fighters = FighterSummaryDTO.map(weightClass.getFighters());
    }
}
