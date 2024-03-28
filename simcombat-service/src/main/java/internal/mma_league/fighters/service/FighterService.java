package internal.mma_league.fighters.service;

import internal.mma_league.fighters.entity.Fighter;
import internal.mma_league.fighters.enums.FightingStyle;
import internal.mma_league.fighters.exception.FighterNotFoundException;
import internal.mma_league.fighters.exception.InvalidFightingStyleException;
import internal.mma_league.fighters.repository.FighterRepository;
import internal.mma_league.fighters.utils.FighterUtils;
import lombok.AllArgsConstructor;
import org.hibernate.type.descriptor.converter.internal.EnumHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FighterService {

    private final FighterRepository fighterRepository;

    public boolean exists(String name){
        return fighterRepository.findById(name).isPresent();
    }

    public Fighter findFighterByName(String name){
        return fighterRepository.findById(name)
                .orElseThrow(() -> new FighterNotFoundException(name + " is not a SimCombat fighter"));
    }

    public List<Fighter> findAllFighters(){
        return fighterRepository.findAll();
    }

    public List<Fighter> findFighterByStyle(String style){
        if(!FightingStyle.isValid(style.toUpperCase())){
            throw new InvalidFightingStyleException(style + " is not a valid fighting style");
        }
        FightingStyle fightingStyle = FightingStyle.valueOf(style.toUpperCase());
        return fighterRepository.findAll().stream()
                .filter(fighter -> FighterUtils.calculateFightingStyle(fighter).equals(fightingStyle))
                .toList();
    }
}
