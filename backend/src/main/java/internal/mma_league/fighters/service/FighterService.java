package internal.mma_league.fighters.service;

import internal.mma_league.fighters.repository.FighterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FighterService {

    private final FighterRepository fighterRepository;

    public boolean exists(String name){
        return fighterRepository.findById(name).isPresent();
    }
}
