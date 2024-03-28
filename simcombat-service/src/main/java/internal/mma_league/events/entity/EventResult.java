package internal.mma_league.events.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "eventResult")
@Table(name = "event_result")
@Getter
@Setter
@NoArgsConstructor
public class EventResult {

    @Id
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<FightResult> fights = new HashSet<>();

    public EventResult(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public void addFight(FightResult fight) {
        this.fights.add(fight);
    }
}
