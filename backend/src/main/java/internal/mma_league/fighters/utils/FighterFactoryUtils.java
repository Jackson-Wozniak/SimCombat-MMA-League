package internal.mma_league.fighters.utils;

import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.fighters.exception.FighterGenerationException;
import internal.mma_league.fighters.service.FighterService;

import java.time.LocalDate;
import java.util.Random;

public class FighterFactoryUtils {

    private static final Random random = new Random();

    //each weight class has a base height, and a random num 0 - 6 is added to that base height to
    //get the final height in inches of the fighter
    public static int randomHeightInches(int weight){
        int number = random.nextInt(7);

        return WeightClassNames.baseHeight(WeightClassNames.convertFromPounds(weight)) + number;
    }

    public static LocalDate randomBirthday(){
        int yearsOld = random.nextInt(9) + 20;

        return LocalDate.now().minusYears(yearsOld).plusDays(random.nextInt(365));
    }

    //bell curve with weight toward average
    public static int randomGrade(){
        int number = random.nextInt(100) + 1;

        if(number <= 10){
            return 15;
        }
        if(number <= 30){
            return 30;
        }
        if(number <= 60){
            return 50;
        }
        if(number <= 80){
            return 70;
        }
        if(number <= 95){
            return 85;
        }
        return 95;
    }

    public static String createValidName(FighterService fighterService){
        int loops = 0;
        while(true){
            if(loops > 1000){
                throw new FighterGenerationException("Cannot create fighter: Problem generating unique name");
            }
            String name = NameGenerator.createRandomName();

            if(!fighterService.exists(name)) return name;

            loops++;
        }
    }
}
