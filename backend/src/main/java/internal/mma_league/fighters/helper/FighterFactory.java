package internal.mma_league.fighters.helper;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.service.FighterService;
import internal.mma_league.fighters.utils.FighterFactoryUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FighterFactory {

    private final FighterService fighterService;

    public Fighter generate(int weight){
       String name = FighterFactoryUtils.createValidName(fighterService);

       return new Fighter.Builder(name, weight)
               .height(FighterFactoryUtils.randomHeightInches(weight))
               .birthday(FighterFactoryUtils.randomBirthday())
               .striking(
                       FighterFactoryUtils.randomGrade(),
                       FighterFactoryUtils.randomGrade()
               )
               .grappling(
                       FighterFactoryUtils.randomGrade(),
                       FighterFactoryUtils.randomGrade()
               )
               .build();
    }
}
