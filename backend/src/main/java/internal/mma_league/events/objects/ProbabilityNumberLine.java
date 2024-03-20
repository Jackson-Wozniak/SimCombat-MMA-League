package internal.mma_league.events.objects;

import lombok.Getter;
import lombok.Setter;

//create a number line 1-100 from a FighterProbability instance
@Getter
public class ProbabilityNumberLine {

    private final int x1UpperBound;
    private final int x2UpperBound;
    private final int y1UpperBound;
    private final int y2UpperBound;
    private final int z1UpperBound;
    private final int z2UpperBound;

    public ProbabilityNumberLine(FighterProbabilities probabilities){
        int numberLine = 1;
        this.x1UpperBound = numberLine + ((int) (probabilities.getFighter1KOChance() * 100));
        this.x2UpperBound = numberLine + ((int) (probabilities.getFighter2KOChance() * 100));
        this.y1UpperBound = numberLine + ((int) (probabilities.getFighter1SubChance() * 100));
        this.y2UpperBound = numberLine + ((int) (probabilities.getFighter2SubChance() * 100));
        this.z1UpperBound = numberLine + ((int) (probabilities.getFighter1NoFinishChance() * 100));
        this.z2UpperBound = numberLine + ((int) (probabilities.getFighter2NoFinishChance() * 100));
    }
}
