package internal.mma_league.events.entity;

import internal.mma_league.events.enums.Outcome;
import internal.mma_league.fighters.entity.Fighter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "fightResult")
@Table(name = "fight_result")
@Getter
@Setter
@NoArgsConstructor
public class FightResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Outcome outcome;

    @Column(name = "ending_round")
    private Integer endingRound;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "winner")
    private Fighter winner;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "loser")
    private Fighter loser;

    public FightResult(Outcome outcome, int round, Fighter winner, Fighter loser) {
        this.outcome = outcome;
        this.endingRound = round;
        this.winner = winner;
        this.loser = loser;
    }
}
