package internal.mma_league.league.entity;

import internal.mma_league.fighters.entity.Fighter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "weightClass")
@Table(name = "weight_class")
@Getter
@Setter
@NoArgsConstructor
public class WeightClass {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Fighter> fighters = new HashSet<>();

    public WeightClass(String name){
        this.name = name;
    }

    public void addFighter(Fighter fighter){
        this.fighters.add(fighter);
    }

    public void addFighters(List<Fighter> fighters){
        this.fighters.addAll(fighters);
    }
}
