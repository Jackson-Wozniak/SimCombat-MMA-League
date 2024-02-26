package com.example.backend.fighters.service;

import com.example.backend.fighters.repository.FighterRepository;
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
