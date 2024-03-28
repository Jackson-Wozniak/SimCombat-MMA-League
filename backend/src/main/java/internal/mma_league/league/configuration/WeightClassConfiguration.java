package internal.mma_league.league.configuration;

import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.league.service.WeightClassService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@AllArgsConstructor
public class WeightClassConfiguration {

    private final WeightClassService weightClassService;
    private static final Logger logger = LoggerFactory.getLogger(WeightClassConfiguration.class);

    @PostConstruct
    public void configureWeightClasses(){
        Set<WeightClassNames> names = WeightClassNames.getAllNames();

        names.forEach(name -> {
            int fighterCount = weightClassService.findFighterCount(name);
            if(fighterCount < 20){
                fighterCount = weightClassService.createAndConfigureWeightClass(name, 20 - fighterCount);
                logger.info("Weight class configured: " + name + " | " + fighterCount + " fighters");
            }else{
                logger.info("Weight class validated: " + name + " | " + fighterCount + " fighters");
            }
        });
    }
}
