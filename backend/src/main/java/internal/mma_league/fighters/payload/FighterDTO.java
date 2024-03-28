package internal.mma_league.fighters.payload;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.enums.FightingStyle;
import internal.mma_league.fighters.utils.FighterUtils;
import internal.mma_league.league.enums.WeightClassNames;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FighterDTO {

    private String name;
    private String weightClass;
    private String height;
    private int age;
    private String record;
    private String fightingStyle;

    public FighterDTO(Fighter fighter){
        this.name = fighter.getName();
        this.weightClass = WeightClassNames.convertFromPounds(fighter.getWeightClass()).toString();
        this.height = FighterUtils.convertHeightToString(fighter.getHeightInInches());
        this.age = FighterUtils.calculateAgeInYears(fighter.getBirthday(), LocalDate.now());
        this.record = fighter.getFormattedRecord();
        this.fightingStyle = FightingStyle.toName(FighterUtils.calculateFightingStyle(fighter));
    }
}
