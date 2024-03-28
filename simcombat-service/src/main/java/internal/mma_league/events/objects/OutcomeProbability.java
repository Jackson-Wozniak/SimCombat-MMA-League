package internal.mma_league.events.objects;

import internal.mma_league.events.exceptions.ProbabilityException;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

import static internal.mma_league.events.utils.Formatting.twoDecimalRound;

@Getter
@Setter
public class OutcomeProbability {

    private double knockoutChancePerRound;
    private double submissionChancePerRound;
    private double noFinishChance;
    private static final DecimalFormat formatter = new DecimalFormat("0.##");

    public OutcomeProbability(double knockoutChance, double submissionChance){
        this.knockoutChancePerRound = twoDecimalRound(knockoutChance / 3.0); //because 3 rounds
        this.submissionChancePerRound = twoDecimalRound(submissionChance / 3.0);
        if(this.knockoutChancePerRound + this.submissionChancePerRound > 1.0){
            throw new ProbabilityException("Sum of probabilities must be 1.0");
        }
        calculateNoFinishChances();
    }

    private void calculateNoFinishChances(){
        this.noFinishChance = twoDecimalRound(1.0 - knockoutChancePerRound - submissionChancePerRound);
    }
}
