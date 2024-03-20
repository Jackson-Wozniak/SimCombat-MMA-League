package internal.mma_league.events.processors;

import internal.mma_league.events.entity.FightResult;
import internal.mma_league.events.entity.Matchup;
import internal.mma_league.events.enums.MatchupPriority;
import internal.mma_league.events.enums.Outcome;
import internal.mma_league.events.objects.FighterProbabilities;
import internal.mma_league.events.objects.InProgressFight;
import internal.mma_league.events.objects.ProbabilityNumberLine;
import internal.mma_league.events.utils.FightProbabilityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class FightProcessors {

    private static final Random random = new Random();

    public FightResult startFight(Matchup matchup){
        int rounds = MatchupPriority.numberOfRounds(matchup.getPriority());

        FighterProbabilities probabilities = FightProbabilityUtils.generateFighterProbabilities(
                        matchup.getWeightClass(), matchup.getFighter1(), matchup.getFighter2());
        InProgressFight fight = new InProgressFight(new ProbabilityNumberLine(probabilities));

        for(int i = 1; i <= rounds; i++){
            Outcome roundOutcome = fight.simulateRound(random.nextInt(100) + 1);

            if(roundOutcome.equals(Outcome.KNOCKOUT)){
                if(fight.isFighter1Wins()){
                    return new FightResult(
                            Outcome.KNOCKOUT,
                            rounds,
                            matchup.getFighter1(),
                            matchup.getFighter2()
                    );
                }
                return new FightResult(
                        Outcome.KNOCKOUT,
                        rounds,
                        matchup.getFighter2(),
                        matchup.getFighter1()
                );
            }
            if(roundOutcome.equals(Outcome.SUBMISSION)){
                if(fight.isFighter1Wins()){
                    return new FightResult(
                            Outcome.SUBMISSION,
                            rounds,
                            matchup.getFighter1(),
                            matchup.getFighter2()
                    );
                }
                return new FightResult(
                        Outcome.SUBMISSION,
                        rounds,
                        matchup.getFighter2(),
                        matchup.getFighter1()
                );
            }
        }
        if(fight.getFighter1Score() > fight.getFighter2Score()){
            return new FightResult(
                    Outcome.DECISION,
                    rounds,
                    matchup.getFighter1(),
                    matchup.getFighter2()
            );
        }
        return new FightResult(
                Outcome.DECISION,
                rounds,
                matchup.getFighter2(),
                matchup.getFighter1()
        );
    }
}
