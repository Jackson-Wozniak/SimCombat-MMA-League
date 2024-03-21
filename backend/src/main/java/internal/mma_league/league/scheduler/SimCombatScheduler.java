package internal.mma_league.league.scheduler;

import internal.mma_league.events.entity.Event;
import internal.mma_league.events.helper.EventScheduler;
import internal.mma_league.events.processors.EventProcessor;
import internal.mma_league.events.service.EventService;
import internal.mma_league.league.entity.SimCombat;
import internal.mma_league.league.properties.SchedulingIntervals;
import internal.mma_league.league.service.SimCombatService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class SimCombatScheduler {

    private final SimCombat simCombat;
    private final SimCombatService simCombatService;
    private final EventProcessor eventProcessor;
    private final EventScheduler eventScheduler;
    private final EventService eventService;
    private static final Logger logger = LoggerFactory.getLogger(SimCombatScheduler.class);

    @Scheduled(fixedRate = SchedulingIntervals.ONE_SECOND)
    public void dailyLeagueProcess(){
        LocalDate currentDate = simCombat.getDate();

        if(currentDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            Event nextEvent = eventService.findNextEvent();
            if(nextEvent == null){ //no events scheduled
                logger.info("Current Date: " + simCombatService.incrementDate());
                return;
            }
            eventProcessor.simulateEvent(nextEvent);
            logger.info("Event Processed: " + nextEvent.getName());
        }else if(currentDate.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            //TODO: schedule next event. Ensure scheduling of weekly events for next 4 saturdays
        }

        logger.info("Current Date: " + simCombatService.incrementDate());
    }
}
