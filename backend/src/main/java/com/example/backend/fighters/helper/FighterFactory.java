package com.example.backend.fighters.helper;

import com.example.backend.fighters.entity.Fighter;
import com.example.backend.fighters.entity.FighterAttributes;
import com.example.backend.fighters.entity.FighterStats;
import com.example.backend.fighters.exception.FighterGenerationException;
import com.example.backend.fighters.service.FighterService;
import com.example.backend.fighters.utils.NameGenerator;
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
