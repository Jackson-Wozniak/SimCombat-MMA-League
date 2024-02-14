package com.example.backend.fighters.entity;

import com.example.backend.fighters.enums.Discipline;
import com.example.backend.fighters.enums.DisciplineLevel;
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

}
