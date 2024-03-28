package internal.mma_league.fighters.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FighterAttributes {

    @Column(name = "striking_ability")
    private Integer strikingAbility;

    @Column(name = "striking_defense")
    private Integer strikingDefense;

    @Column(name = "grappling_ability")
    private Integer grapplingAbility;

    @Column(name = "grappling_defense")
    private Integer grapplingDefense;

    public FighterAttributes(){
        this.strikingAbility = 0;
        this.strikingDefense = 0;
        this.grapplingAbility = 0;
        this.grapplingDefense = 0;
    }

    public FighterAttributes(int strikingAbility, int strikingDefense,
                             int grapplingAbility, int grapplingDefense){
        this.strikingAbility = strikingAbility;
        this.strikingDefense = strikingDefense;
        this.grapplingAbility = grapplingAbility;
        this.grapplingDefense = grapplingDefense;
    }

    public int sumOfAttributes(){
        return this.strikingAbility + strikingDefense + grapplingAbility + grapplingDefense;
    }
}
