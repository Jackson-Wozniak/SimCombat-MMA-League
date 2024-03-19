package internal.mma_league.fighters.entity;

import internal.mma_league.fighters.enums.Discipline;
import internal.mma_league.fighters.enums.DisciplineLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Column(name = "height_inches")
    private Integer heightInInches;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Embedded
    private FighterStats stats;

    @Embedded
    private FighterAttributes attributes;

    public Fighter(Builder builder){
        this.name = builder.name;
        this.weightClass = builder.weightClass;
        this.heightInInches = builder.height;
        this.birthday = builder.birthday;
        this.stats = new FighterStats();
        this.attributes = new FighterAttributes(
                builder.discipline, builder.disciplineLevel, builder.grade);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        Fighter copy = (Fighter) obj;

        if(this.name == null || copy.name == null) return false;

        return this.name.equals(copy.name);
    }

    public static class Builder{

        private final String name;
        private final int weightClass;
        private int height;
        private LocalDate birthday;
        private Discipline discipline;
        private DisciplineLevel disciplineLevel;
        private int grade;

        public Builder(String name, int weightClass){
            this.name = name;
            this.weightClass = weightClass;
        }

        public Builder height(int height){
            this.height = height;
            return this;
        }

        public Builder birthday(LocalDate birthday){
            this.birthday = birthday;
            return this;
        }

        public Builder discipline(Discipline discipline, DisciplineLevel disciplineLevel){
            this.discipline = discipline;
            this.disciplineLevel = disciplineLevel;
            return this;
        }

        public Builder grade(int grade){
            this.grade = grade;
            return this;
        }

        public Fighter build(){
            return new Fighter(this);
        }
    }
}
