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
    private Integer weightClass;

    @Embedded
    private FighterStats stats;

    @Embedded
    private FighterAttributes attributes;

    public Fighter(String name, int weightClass, FighterStats stats, FighterAttributes attributes){
        this.name = name;
        this.weightClass = weightClass;
        this.stats = stats;
        this.attributes = attributes;
    }

    //only important attribute in comparison is the name (ID)
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        Fighter copy = (Fighter) obj;

        if(this.name == null || copy.name == null) return false;

        return this.name.equals(copy.name);
    }
}
