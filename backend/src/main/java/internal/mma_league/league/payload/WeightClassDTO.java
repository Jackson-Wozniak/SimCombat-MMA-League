package internal.mma_league.league.payload;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.payload.FighterSummaryDTO;
import internal.mma_league.league.entity.WeightClass;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class WeightClassDTO {

    private final String weight;
    private final Set<FighterSummaryDTO> fighters;

    public WeightClassDTO(WeightClass weightClass){
        this.weight = weightClass.getName();
        this.fighters = map(weightClass.getFighters());
    }

    public Set<FighterSummaryDTO> map(Set<Fighter> fighters){
        List<Fighter> sortedFighters = fighters.stream().sorted(Fighter.myClassComparator).toList();

        return IntStream.range(0, sortedFighters.size())
                .mapToObj(i -> new FighterSummaryDTO(sortedFighters.get(i), i + 1))
                .sorted(Comparator.comparingInt(FighterSummaryDTO::getRanking))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
