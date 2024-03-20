package internal.mma_league.events.objects;

import internal.mma_league.events.exceptions.ProbabilityException;
import internal.mma_league.fighters.enums.WeightClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class OutcomeProbability {

    private double knockoutChancePerRound;
    private double submissionChancePerRound;
    private double noFinishChance;
    private static final DecimalFormat formatter = new DecimalFormat("0.##");

    public OutcomeProbability(double knockoutChance, double submissionChance){
        this.knockoutChancePerRound = format(knockoutChance / 3.0); //because 3 rounds
        this.submissionChancePerRound = format(submissionChance / 3.0);
        if(this.knockoutChancePerRound + this.submissionChancePerRound > 1.0){
            throw new ProbabilityException("Sum of probabilities must be 1.0");
        }
        calculateNoFinishChances();
    }

    private void calculateNoFinishChances(){
        this.noFinishChance = 1.0 - knockoutChancePerRound - submissionChancePerRound;
    }

    private double format(double d){
        return Double.parseDouble(formatter.format(d));
    }
}
