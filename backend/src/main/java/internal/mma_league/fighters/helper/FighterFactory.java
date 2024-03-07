package internal.mma_league.fighters.helper;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.entity.FighterAttributes;
import internal.mma_league.fighters.entity.FighterStats;
import internal.mma_league.fighters.exception.FighterGenerationException;
import internal.mma_league.fighters.service.FighterService;
import internal.mma_league.fighters.utils.NameGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FighterFactory {

    private final FighterService fighterService;

    public Fighter generate(int weight){
       String name = createValidName();

       return new Fighter(name, weight, randomFighterLevel(), randomFighterArchetype());
    }

    private FighterAttributes randomFighterArchetype(){

        return null;
    }

    private FighterStats randomFighterLevel(){

        return null;
    }

    private String createValidName(){
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
