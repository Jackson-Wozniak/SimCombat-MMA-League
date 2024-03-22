package internal.mma_league.league.configuration;

import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.league.service.WeightClassService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@AllArgsConstructor
public class WeightClassConfiguration {

    private final WeightClassService weightClassService;

    @PostConstruct
    public void configureWeightClasses(){
        Set<WeightClassNames> names = WeightClassNames.getAllNames();

        names.forEach(name -> {
            int fighterCount = weightClassService.findFighterCount(name);
            if(fighterCount == 0){
                weightClassService.createAndConfigureWeightClass(name, 20);
                return;
            }
            if(fighterCount < 20){
                weightClassService.createAndConfigureWeightClass(name, 20 - fighterCount);
            }
        });
    }
}
