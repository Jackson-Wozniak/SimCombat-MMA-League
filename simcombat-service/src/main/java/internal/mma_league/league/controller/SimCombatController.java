package internal.mma_league.league.controller;

import internal.mma_league.events.service.EventService;
import internal.mma_league.league.entity.SimCombat;
import internal.mma_league.league.payload.SimCombatDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class SimCombatController {

    private final SimCombat simCombat;
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<SimCombatDTO> getSimCombatStatus(){
        return ResponseEntity.ok(new SimCombatDTO(simCombat, eventService.findEventInfo()));
    }
}
