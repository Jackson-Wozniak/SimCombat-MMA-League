package internal.mma_league.fighters.enums;

import internal.mma_league.fighters.exception.InvalidWeightClassException;

public enum WeightClass {

    FLYWEIGHT, //125
    BANTAMWEIGHT, //135
    FEATHERWEIGHT, //145
    LIGHTWEIGHT, //155
    WELTERWEIGHT, //170
    MIDDLEWEIGHT, //185
    LIGHT_HEAVYWEIGHT, //205
    HEAVYWEIGHT; //up to 265

    public static WeightClass convertFromPounds(int weight){
        return switch (weight){
            case 125 -> FLYWEIGHT;
            case 135 -> BANTAMWEIGHT;
            case 145 -> FEATHERWEIGHT;
            case 155 -> LIGHTWEIGHT;
            case 170 -> WELTERWEIGHT;
            case 185 -> MIDDLEWEIGHT;
            case 205 -> LIGHT_HEAVYWEIGHT;
            case 265 -> HEAVYWEIGHT;
            default -> throw new InvalidWeightClassException(weight);
        };
    }

    public static int convertToPounds(WeightClass weightClass){
        return switch (weightClass){
            case FLYWEIGHT -> 125;
            case BANTAMWEIGHT -> 135;
            case FEATHERWEIGHT -> 145;
            case LIGHTWEIGHT -> 155;
            case WELTERWEIGHT -> 170;
            case MIDDLEWEIGHT -> 185;
            case LIGHT_HEAVYWEIGHT -> 205;
            case HEAVYWEIGHT -> 265;
        };
    }

    public static int baseHeight(WeightClass weightClass){
        return switch (weightClass){
            case FLYWEIGHT -> 63;
            case BANTAMWEIGHT -> 64;
            case FEATHERWEIGHT -> 65;
            case LIGHTWEIGHT -> 67;
            case WELTERWEIGHT -> 69;
            case MIDDLEWEIGHT -> 71;
            case LIGHT_HEAVYWEIGHT -> 73;
            case HEAVYWEIGHT -> 74;
        };
    }
}
