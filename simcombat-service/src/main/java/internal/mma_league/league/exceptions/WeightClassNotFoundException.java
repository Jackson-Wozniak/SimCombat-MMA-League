package internal.mma_league.league.exceptions;

public class WeightClassNotFoundException extends RuntimeException{
    public WeightClassNotFoundException(String name, boolean inDatabase){
        super("Weight class: " + name + " doesn't exist" +
                (inDatabase ? " in database" : ""));
    }
}
