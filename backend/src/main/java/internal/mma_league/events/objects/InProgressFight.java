package internal.mma_league.events.objects;

import internal.mma_league.events.enums.Outcome;
import internal.mma_league.fighters.entity.Fighter;
import lombok.Getter;
import lombok.Setter;

@Getter
public class InProgressFight {

    private int fighter1Score;
    private int fighter2Score;
    private ProbabilityNumberLine numberLine;
    private boolean fighter1Wins;
    private boolean fighter2Wins;

    public InProgressFight(ProbabilityNumberLine numberLine){
        this.numberLine = numberLine;
        this.fighter1Score = 0;
        this.fighter2Score = 0;
        this.fighter1Wins = false;
        this.fighter2Wins = false;
    }

    public Outcome simulateRound(int random){
        if(random <= numberLine.getX1UpperBound()){
            this.fighter1Wins = true;
            return Outcome.KNOCKOUT;
        }
        if(random <= numberLine.getX2UpperBound()){
            this.fighter2Wins = true;
            return Outcome.KNOCKOUT;
        }
        if(random <= numberLine.getY1UpperBound()){
            this.fighter1Wins = true;
            return Outcome.SUBMISSION;
        }
        if(random <= numberLine.getY2UpperBound()){
            this.fighter2Wins = true;
            return Outcome.SUBMISSION;
        }
        if(random <= numberLine.getZ1UpperBound()){
            this.fighter1Score += 10;
            return Outcome.DECISION;
        }
        if(random <= numberLine.getZ2UpperBound()){
            this.fighter2Score += 10;
            return Outcome.DECISION;
        }
        throw new RuntimeException("Out of range");
    }
}
