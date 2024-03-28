package internal.mma_league.events.service;

import internal.mma_league.events.entity.Event;
import internal.mma_league.events.entity.EventResult;
import internal.mma_league.events.exceptions.EventNotFoundException;
import internal.mma_league.events.repository.EventResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EventResultService {

    private final EventResultRepository eventResultRepository;

    public void saveEventResult(EventResult eventResult){
        this.eventResultRepository.save(eventResult);
    }

    public EventResult findEventResultByName(String name) throws EventNotFoundException {
        return this.eventResultRepository.findById(name)
                .orElseThrow(() -> new EventNotFoundException("Cannot find event " + name));
    }

    public EventResult findEventByDate(LocalDate date) throws EventNotFoundException {
        return this.eventResultRepository.findAll().stream()
                .filter(event -> event.getDate().equals(date))
                .findAny()
                .orElseThrow(() -> new EventNotFoundException("Cannot find event on " + date));
    }

    public List<EventResult> findEventInDateRange(LocalDate start, LocalDate end) throws EventNotFoundException {
        List<EventResult> events = this.eventResultRepository.findAll().stream()
                .filter(event -> event.getDate().isBefore(end) && event.getDate().isAfter(start))
                .toList();
        if(events.isEmpty()) throw new EventNotFoundException("No events in this range");
        return events;
    }

    //TODO: public boolean deleteEventResult(EventResult eventResult)
}
