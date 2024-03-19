package internal.mma_league.fighters.entity;

import internal.mma_league.fighters.enums.Discipline;
import internal.mma_league.fighters.enums.DisciplineLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FighterAttributes {

    @Enumerated(value = EnumType.STRING)
    private Discipline discipline;

    @Enumerated(value = EnumType.STRING)
    private DisciplineLevel disciplineLevel;

    @Column(name = "grade")
    private Integer grade;

    public FighterAttributes(Discipline discipline, DisciplineLevel disciplineLevel, int grade){
        this.discipline = discipline;
        this.disciplineLevel = disciplineLevel;
        this.grade = grade;
    }
}
