package internal.mma_league.events.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "event")
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<Matchup> matchups = new HashSet<>();

    public Event(Builder builder){
        this.name = builder.name;
        this.date = builder.date;
        this.addMatchup(builder.mainEvent);
        this.addMatchup(builder.coMainEvent);
        this.addMatchups(builder.undercard);
        this.addMatchups(builder.prelims);
    }

    public void addMatchup(Matchup matchup){
        this.matchups.add(matchup);
    }

    public void addMatchups(List<Matchup> newMatchups){
        this.matchups.addAll(newMatchups);
    }

    public static class Builder{
        private final String name;
        private final LocalDate date;
        private Matchup mainEvent;
        private Matchup coMainEvent;
        private List<Matchup> undercard;
        private List<Matchup> prelims;

        public Builder(String name, LocalDate date){
            this.name = name;
            this.date = date;
        }

        public Builder mainEvent(Matchup mainEvent){
            this.mainEvent = mainEvent;
            return this;
        }

        public Builder coMainEvent(Matchup coMainEvent){
            this.coMainEvent = coMainEvent;
            return this;
        }

        public Builder undercard(List<Matchup> undercard){
            this.undercard = undercard;
            return this;
        }

        public Builder prelims(List<Matchup> prelims){
            this.prelims = prelims;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }
}
