package internal.mma_league.events.objects;

import internal.mma_league.events.utils.WinProbabilityUtils;
import internal.mma_league.fighters.entity.Fighter;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class FighterProbabilities {

    private double fighter1KOChance;
    private double fighter2KOChance;
    private double fighter1SubChance;
    private double fighter2SubChance;
    private double fighter1NoFinishChance;
    private double fighter2NoFinishChance;
    private static final DecimalFormat formatter = new DecimalFormat("0.##");

    public FighterProbabilities(OutcomeProbability outcomeProbability, Fighter fighter1, Fighter fighter2){
        setFighterChances(fighter1, fighter2, outcomeProbability);
        setFighterChances(fighter2, fighter1, outcomeProbability);
    }

    public void setFighterChances(Fighter fighter1, Fighter fighter2, OutcomeProbability outcomeProbability){
        double winProb = WinProbabilityUtils.fighter1WinProbability(fighter1, fighter2);

        int strikingDifference = (fighter1.getAttributes().getStrikingAbility() - 50) +
                (fighter2.getAttributes().getStrikingDefense() - 50);
        int grapplingDifference = (fighter1.getAttributes().getGrapplingAbility() - 50) +
                (fighter2.getAttributes().getGrapplingDefense() - 50);

        double KOChance = outcomeProbability.getKnockoutChancePerRound() +
                (outcomeProbability.getKnockoutChancePerRound() * (strikingDifference / 100.0));
        double weightedKOChance = KOChance * winProb;
        setFighter1KOChance(format(weightedKOChance));

        double subChance = outcomeProbability.getSubmissionChancePerRound() +
                (outcomeProbability.getSubmissionChancePerRound() * (grapplingDifference / 100.0));
        double weightedSubChance = subChance * winProb;
        setFighter1KOChance(format(weightedKOChance));

        setFighter1NoFinishChance(format(winProb - weightedKOChance - weightedSubChance));
    }

    private double format(double d){
        return Double.parseDouble(formatter.format(d));
    }
}
