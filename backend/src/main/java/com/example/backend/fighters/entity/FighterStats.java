package com.example.backend.fighters.entity;

import com.example.backend.fighters.enums.ChampionRank;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class FighterStats {

    private Integer wins;
    private Integer losses;
    private Integer noContests;
    private Integer finishes;
    private Integer elo;
    @Enumerated(EnumType.STRING)
    private ChampionRank championRank;

    public FighterStats(int elo, ChampionRank rank){
        this.wins = 0;
        this.losses = 0;
        this.noContests = 0;
        this.finishes = 0;
        this.elo = elo;
        this.championRank = rank;
    }
}
