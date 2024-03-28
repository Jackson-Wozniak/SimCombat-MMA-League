package internal.mma_league.events.enums;

public enum MatchupPriority {
    MAIN_EVENT,
    CO_MAIN_EVENT,
    UNDER_CARD,
    PRELIMS;

    public static int numberOfRounds(MatchupPriority matchupPriority){
        return switch (matchupPriority){
            case MAIN_EVENT, CO_MAIN_EVENT -> 5;
            default -> 3;
        };
    }
}
