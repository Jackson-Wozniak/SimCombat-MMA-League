package internal.mma_league.league.service;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.helper.FighterFactory;
import internal.mma_league.league.entity.WeightClass;
import internal.mma_league.league.enums.WeightClassNames;
import internal.mma_league.league.exceptions.WeightClassNotFoundException;
import internal.mma_league.league.repository.WeightClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WeightClassService {

    private final WeightClassRepository weightClassRepository;
    private final FighterFactory fighterFactory;

    public WeightClass findWeightClass(WeightClassNames name){
        return weightClassRepository.findById(name.toString())
                .orElseThrow(() -> new WeightClassNotFoundException(name.toString(), true));
    }

    public WeightClass findWeightClass(String name){
        return weightClassRepository.findById(name)
                .orElseThrow(() -> new WeightClassNotFoundException(name, true));
    }

    public int createAndConfigureWeightClass(WeightClassNames name, int count){
        WeightClass weightClass = weightClassRepository.findById(name.toString())
                .orElse(new WeightClass(name.toString()));
        for(int i = 0; i < count; i++){
            Fighter temp = fighterFactory.generate(WeightClassNames.convertToPounds(name));
            weightClass.addFighter(temp);
        }
        return weightClassRepository.save(weightClass).getFighters().size();
    }

    public int findFighterCount(WeightClassNames name){
        Optional<WeightClass> weightClass = weightClassRepository.findById(name.toString());

        return weightClass.map(aClass -> aClass.getFighters().size()).orElse(0);
    }
}
