package internal.mma_league.fighters.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;

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

    @Column(name = "scheduled_fight")
    private Boolean hasScheduledFlight;

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
                builder.strikingAbility, builder.strikingDefense,
                builder.grapplingAbility, builder.grapplingDefense);
        this.hasScheduledFlight = false;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        Fighter copy = (Fighter) obj;

        if(this.name == null || copy.name == null) return false;

        return this.name.equals(copy.name);
    }

    public static Comparator<Fighter> myClassComparator = new Comparator<Fighter>() {
        @Override
        public int compare(Fighter f1, Fighter f2) {
            // First sort by attr1
            int compareAttr1 = Integer.compare(f1.getStats().getElo(), f2.getStats().getElo());
            if (compareAttr1 != 0) {
                return compareAttr1;
            }

            // If elo is the same, sort by wins
            int compareAttr2 = Integer.compare(
                    f1.getStats().getRecord().getWins(),
                    f2.getStats().getRecord().getWins());
            if (compareAttr2 != 0) {
                return compareAttr2;
            }

            // If wins is the same, sort by losses
            int compareAttr3 = Integer.compare(
                    f1.getStats().getRecord().getLosses(),
                    f2.getStats().getRecord().getLosses());
            if (compareAttr3 != 0) {
                return compareAttr3;
            }

            // If losses is the same, sort by total ability
            int compareAttr4 = Integer.compare(
                    f1.getAttributes().sumOfAttributes(),
                    f2.getAttributes().sumOfAttributes());
            if (compareAttr4 != 0) {
                return compareAttr4;
            }

            //return 1st fighter if all are the same
            return 1;
        }
    };

    public static class Builder{

        private final String name;
        private final int weightClass;
        private int height;
        private LocalDate birthday;
        private int strikingAbility;
        private int strikingDefense;
        private int grapplingAbility;
        private int grapplingDefense;

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

        public Builder striking(int strikingAbility, int strikingDefense){
            this.strikingAbility = strikingAbility;
            this.strikingDefense = strikingDefense;
            return this;
        }

        public Builder grappling(int grapplingAbility, int grapplingDefense){
            this.grapplingAbility = grapplingAbility;
            this.grapplingDefense = grapplingDefense;
            return this;
        }

        public Fighter build(){
            return new Fighter(this);
        }
    }
}
