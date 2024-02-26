package com.example.backend.fighters.entity;

import com.example.backend.fighters.enums.Discipline;
import com.example.backend.fighters.enums.DisciplineLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class FighterAttributes {

    @Enumerated(value = EnumType.STRING)
    private Discipline discipline;

    @Enumerated(value = EnumType.STRING)
    private DisciplineLevel disciplineLevel;

    @Column(name = "fighter_grade")
    private Integer grade;

    public FighterAttributes(Discipline discipline, DisciplineLevel disciplineLevel, int grade){
        this.discipline = discipline;
        this.disciplineLevel = disciplineLevel;
        this.grade = grade;
    }
}
