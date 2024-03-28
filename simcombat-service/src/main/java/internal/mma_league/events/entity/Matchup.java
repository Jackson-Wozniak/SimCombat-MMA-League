package internal.mma_league.events.entity;

import internal.mma_league.events.enums.MatchupPriority;
import internal.mma_league.fighters.entity.Fighter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "matchup")
@Table(name = "matchup")
@Getter
@Setter
@NoArgsConstructor
public class Matchup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight_class")
    private Integer weightClass;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fighter_1")
    private Fighter fighter1;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fighter_2")
    private Fighter fighter2;

    @Enumerated(EnumType.STRING)
    private MatchupPriority priority;

    public Matchup(int weight, Fighter f1, Fighter f2, MatchupPriority priority){
        this.weightClass = weight;
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.priority = priority;
    }
}
