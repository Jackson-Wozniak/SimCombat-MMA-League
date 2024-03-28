package internal.mma_league.events.objects;

import internal.mma_league.events.utils.WinProbabilityUtils;
import internal.mma_league.fighters.entity.Fighter;
import lombok.Getter;
import lombok.Setter;

import static internal.mma_league.events.utils.Formatting.twoDecimalRound;

@Getter
@Setter
public class FighterProbabilities {

    private double fighter1KOChance;
    private double fighter2KOChance;
    private double fighter1SubChance;
    private double fighter2SubChance;
    private double fighter1NoFinishChance;
    private double fighter2NoFinishChance;

    public FighterProbabilities(OutcomeProbability outcomeProbability, Fighter fighter1, Fighter fighter2){
        double winProb1 = WinProbabilityUtils.fighter1WinProbability(fighter1, fighter2);
        double winProb2 = 1 - winProb1;

        this.fighter1KOChance = KOChance(winProb1, fighter1, fighter2, outcomeProbability);
        setFighter2KOChance(KOChance(winProb2, fighter2, fighter1, outcomeProbability));

        setFighter1SubChance(subChance(winProb1, fighter1, fighter2, outcomeProbability));
        setFighter2SubChance(subChance(winProb2, fighter2, fighter1, outcomeProbability));

        setFighter1NoFinishChance(noFinishChance(winProb1, fighter1KOChance, fighter1SubChance));
        setFighter2NoFinishChance(noFinishChance(winProb2, fighter2KOChance, fighter2SubChance));
    }


    private double KOChance(double winProb, Fighter f1, Fighter f2, OutcomeProbability outcomeProbability){
        int strikingDifference = (f1.getAttributes().getStrikingAbility() - 50) -
                (f2.getAttributes().getStrikingDefense() - 50);

        double KOChance = outcomeProbability.getKnockoutChancePerRound() +
                (outcomeProbability.getKnockoutChancePerRound() * (strikingDifference / 100.0));

        return twoDecimalRound(KOChance * winProb);
    }

    private double subChance(double winProb, Fighter f1, Fighter f2, OutcomeProbability outcomeProbability){
        int grapplingDifference = (f1.getAttributes().getGrapplingAbility() - 50) -
                (f2.getAttributes().getGrapplingDefense() - 50);

        double subChance = outcomeProbability.getSubmissionChancePerRound() +
                (outcomeProbability.getSubmissionChancePerRound() * (grapplingDifference / 100.0));
        return twoDecimalRound(subChance * winProb);
    }

    private double noFinishChance(double winProb, double KOChance, double subChance){
        return twoDecimalRound(winProb - KOChance - subChance);
    }
}
