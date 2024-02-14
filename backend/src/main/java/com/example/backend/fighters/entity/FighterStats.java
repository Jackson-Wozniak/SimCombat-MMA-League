package com.example.backend.fighters.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FighterStats {

    private Integer wins;
    private Integer losses;
    private Integer noContests;
    private Integer finishes;
}
