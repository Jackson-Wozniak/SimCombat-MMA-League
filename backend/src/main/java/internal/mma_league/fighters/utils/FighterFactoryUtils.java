package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.exception.FighterGenerationException;
import internal.mma_league.fighters.service.FighterService;

import java.util.Random;

public class FighterFactoryUtils {

    private static final Random random = new Random();

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
