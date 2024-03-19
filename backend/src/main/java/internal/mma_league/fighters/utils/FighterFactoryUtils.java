package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.enums.Discipline;
import internal.mma_league.fighters.enums.DisciplineLevel;
import internal.mma_league.fighters.enums.WeightClass;
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

        return WeightClass.baseHeight(WeightClass.convertFromPounds(weight)) + number;
    }

    public static LocalDate randomBirthday(){
        int yearsOld = random.nextInt(9) + 20;

        return LocalDate.now().minusYears(yearsOld).plusDays(random.nextInt(365));
    }

    //40% chance of MMA discipline, 20% of all others
    public static Discipline randomDiscipline(){
        int number = random.nextInt(100) + 1;

        if(number <= 40){
            return Discipline.MIXED_MARTIAL_ARTIST;
        }
        if(number <= 60){
            return Discipline.KICKBOXER;
        }
        if(number <= 80){
            return Discipline.JIU_JITSU;
        }
        return Discipline.WRESTLER;
    }

    //bell curve with weight toward average
    public static DisciplineLevel randomDisciplineLevel(){
        int number = random.nextInt(100) + 1;

        if(number <= 10){
            return DisciplineLevel.BEGINNER;
        }
        if(number <= 30){
            return DisciplineLevel.INTERMEDIATE;
        }
        if(number <= 60){
            return DisciplineLevel.AVERAGE;
        }
        if(number <= 80){
            return DisciplineLevel.EXPERIENCED;
        }
        if(number <= 95){
            return DisciplineLevel.EXPERT;
        }
        return DisciplineLevel.MASTER;
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