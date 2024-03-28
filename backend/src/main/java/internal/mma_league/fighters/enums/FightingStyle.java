package internal.mma_league.fighters.enums;

public enum FightingStyle {
    MIXED_MARTIAL_ARTIST,
    STRIKER,
    WRESTLER;

    public static String toName(FightingStyle fightingStyle){
        return switch (fightingStyle){
            case MIXED_MARTIAL_ARTIST -> "Mixed Martial Artist";
            case STRIKER -> "Striker";
            case WRESTLER -> "Wrestler";
        };
    }

    public static boolean isValid(String fightingStyle){
        try{
            FightingStyle.valueOf(fightingStyle);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
