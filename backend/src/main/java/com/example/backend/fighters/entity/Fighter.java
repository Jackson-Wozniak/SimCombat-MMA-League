package com.example.backend.fighters.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "fighter")
@Table(name = "fighter")
@Getter
@Setter
@NoArgsConstructor
public class Fighter {

    @Id
    private String name;

    @Column(name = "weight_class")
    private Double weightClass;

    @Embedded
    private FighterStats stats;

    @Embedded
    private FighterAttributes attributes;

    public Fighter(String name, double weightClass, FighterStats stats, FighterAttributes attributes){
        this.name = name;
        this.weightClass = weightClass;
        this.stats = stats;
        this.attributes = attributes;
    }
}
