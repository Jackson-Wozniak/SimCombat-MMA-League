package internal.mma_league.league.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "simCombat")
@Table(name = "sim_combat")
@Getter
@Setter
@NoArgsConstructor
public class SimCombat {

    @Id
    private Integer id;

    @Column(name = "league_date")
    private LocalDate date;

    public SimCombat(LocalDate date){
        this.id = 1;
        this.date = date;
    }

    public void incrementDate(){
        date = date.plusDays(1);
    }
}
