package internal.mma_league.events.service;

import internal.mma_league.events.entity.Event;
import internal.mma_league.events.exceptions.EventNotFoundException;
import internal.mma_league.events.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void saveEvent(Event event){
        this.eventRepository.save(event);
    }

    public Event findEventByName(String name) throws EventNotFoundException {
        return this.eventRepository.findById(name)
                .orElseThrow(() -> new EventNotFoundException("Cannot find event " + name));
    }

    public Event findEventByDate(LocalDate date) throws EventNotFoundException {
        return this.eventRepository.findAll().stream()
                .filter(event -> event.getDate().equals(date))
                .findAny()
                .orElseThrow(() -> new EventNotFoundException("Cannot find event on " + date));
    }

    public List<Event> findEventInDateRange(LocalDate start, LocalDate end) throws EventNotFoundException {
        List<Event> events = this.eventRepository.findAll().stream()
                .filter(event -> event.getDate().isBefore(end) && event.getDate().isAfter(start))
                .toList();
        if(events.isEmpty()) throw new EventNotFoundException("No events in this range");
        return events;
    }

    //TODO: public boolean deleteEvent(Event event)

    //TODO: public boolean deleteEventAndCreateEventResult(Event event, EventResult eventResult)
}
