package internal.mma_league.fighters.payload;

import internal.mma_league.fighters.entity.Fighter;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class FighterSummaryDTO {

    private final String name;
    private final int ranking;
    private final String record;

    public FighterSummaryDTO(Fighter fighter, int ranking){
        this.name = fighter.getName();
        this.ranking = ranking;
        this.record = fighter.getFormattedRecord();
    }

    public static Set<FighterSummaryDTO> map(Set<Fighter> fighters){
         List<Fighter> sortedFighters = fighters.stream().sorted(Fighter.myClassComparator).toList();

        return IntStream.range(0, sortedFighters.size())
                .mapToObj(i -> new FighterSummaryDTO(sortedFighters.get(i), i + 1))
                .collect(Collectors.toSet());
    }
}
