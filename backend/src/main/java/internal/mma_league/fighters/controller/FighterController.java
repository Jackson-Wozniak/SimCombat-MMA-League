package internal.mma_league.fighters.controller;

import internal.mma_league.fighters.payload.FighterDTO;
import internal.mma_league.fighters.service.FighterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/fighters")
@AllArgsConstructor
public class FighterController {

    private final FighterService fighterService;

    @GetMapping
    public ResponseEntity<List<FighterDTO>> getFighters(){
        return ResponseEntity.ok(
                fighterService.findAllFighters().stream()
                        .map(FighterDTO::new)
                        .toList()
        );
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<?> getFighterByName(@PathVariable("name") String name){
        name = name.replace("_", " ");
        return ResponseEntity.ok(new FighterDTO(fighterService.findFighterByName(name)));
    }

    @GetMapping(value = "styles/{style}")
    public ResponseEntity<List<FighterDTO>> getFightersByStyle(@PathVariable("style") String style){
        return ResponseEntity.ok(
                fighterService.findFighterByStyle(style).stream()
                        .map(FighterDTO::new)
                        .toList()
        );
    }
}
