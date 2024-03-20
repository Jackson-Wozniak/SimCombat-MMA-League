package internal.mma_league.events.entity;

import internal.mma_league.events.enums.Outcome;
import internal.mma_league.events.objects.InProgressFight;
import internal.mma_league.fighters.entity.Fighter;

public class FightResult {

    private Outcome outcome;
    private Integer round;
    private Fighter winner;
    private Fighter loser;

    public FightResult(Outcome outcome, Integer round, Fighter winner, Fighter loser) {
        this.outcome = outcome;
        this.round = round;
        this.winner = winner;
        this.loser = loser;
    }
}
