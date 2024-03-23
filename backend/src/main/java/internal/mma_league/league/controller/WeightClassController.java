package internal.mma_league.league.controller;

import internal.mma_league.fighters.exception.InvalidWeightClassException;
import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.league.payload.WeightClassDTO;
import internal.mma_league.league.service.WeightClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/weights")
@AllArgsConstructor
public class WeightClassController {

    private final WeightClassService weightClassService;

    @GetMapping(value = "/{weight}")
    public ResponseEntity<?> getWeightClass(@PathVariable("weight") String weightStr){
        int weight;
        try{
            weight = Integer.parseInt(weightStr);
        }catch(Exception ex){
            throw new InvalidWeightClassException(weightStr);
        }
        WeightClassNames weightClass = WeightClassNames.convertFromPounds(weight);
        return ResponseEntity.ok(new WeightClassDTO(weightClassService.findWeightClass(weightClass)));
    }
}
