package internal.mma_league.fighters.entity;

import internal.mma_league.events.enums.Outcome;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FighterRecord {

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "losses")
    private Integer losses;

    @Column(name = "knockouts")
    private Integer knockouts;

    @Column(name = "submissions")
    private Integer submissions;

    @Column(name = "times_finished")
    private Integer timesFinished;

    public FighterRecord(){
        this.wins = 0;
        this.losses = 0;
        this.knockouts = 0;
        this.submissions = 0;
        this.timesFinished = 0;
    }

    public int totalFights(){
        return this.wins + this.losses;
    }

    public void incrementWins(){
        this.wins += 1;
    }

    public void incrementLosses(){
        this.losses += 1;
    }

    public void incrementOutcomes(Outcome outcome, boolean wonFight){
        switch (outcome){
            case KNOCKOUT:
                if(wonFight){
                    this.knockouts += 1;
                }else{
                    this.timesFinished += 1;
                }
                break;
            case SUBMISSION:
                if(wonFight){
                    this.submissions += 1;
                }else{
                    this.timesFinished += 1;
                }
                break;
        }
    }
}
