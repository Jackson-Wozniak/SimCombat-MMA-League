package internal.mma_league.league.configuration;

import internal.mma_league.league.entity.SimCombat;
import internal.mma_league.league.repository.SimCombatRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@AllArgsConstructor
public class SimCombatConfiguration {

    private final SimCombatRepository simCombatRepository;
    private static final Logger logger = LoggerFactory.getLogger(SimCombatConfiguration.class);

    @Bean
    public SimCombat simCombat(){
        SimCombat object = simCombatRepository.findById(1).orElseGet(() -> {
            SimCombat simCombat = new SimCombat(LocalDate.now());

            return simCombatRepository.save(simCombat);
        });

        logger.info("SimCombat League started. Current date: " + object.getDate());
        return object;
    }
}
