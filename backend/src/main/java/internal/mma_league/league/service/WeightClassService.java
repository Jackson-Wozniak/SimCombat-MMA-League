package internal.mma_league.league.service;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.helper.FighterFactory;
import internal.mma_league.league.entity.WeightClass;
import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.league.exceptions.WeightClassNotFoundException;
import internal.mma_league.league.repository.WeightClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeightClassService {

    private final WeightClassRepository weightClassRepository;
    private final FighterFactory fighterFactory;

    public void createAndConfigureWeightClass(WeightClassNames name, int count){
        WeightClass weightClass = weightClassRepository.findById(name.toString())
                .orElse(new WeightClass(name.toString()));
        for(int i = 0; i < count; i++){
            Fighter temp = fighterFactory.generate(WeightClassNames.convertToPounds(name));
            weightClass.addFighter(temp);
        }
        weightClassRepository.save(weightClass);
    }

    public int findFighterCount(WeightClassNames weightClass){
        return weightClassRepository.findById(weightClass.toString())
                .orElseGet(() -> new WeightClass("EMPTY"))
                .getFighters().size();
    }
}
