package internal.mma_league.fighters.entity;

import internal.mma_league.fighters.enums.ChampionRank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FighterStats {

    @Column(name = "elo_rating")
    private Integer elo;

    @Embedded
    private FighterRecord record;

    @Enumerated(EnumType.STRING)
    private ChampionRank championRank;

    @Column(name = "legacy_score")
    private Integer legacyScore;

    @Column(name = "fans")
    private Integer fans;

    @Column(name = "longevity")
    private Integer longevity;

    public FighterStats(){
        this.elo = 1000;
        this.record = new FighterRecord();
        this.championRank = ChampionRank.NON_RANKED;
        this.legacyScore = 0;
        this.fans = 0;
        this.longevity = 100;
    }

}
