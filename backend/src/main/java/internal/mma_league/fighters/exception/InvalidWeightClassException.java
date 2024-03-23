package internal.mma_league.fighters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no weight class exists at that weight")
public class InvalidWeightClassException extends RuntimeException{
    public InvalidWeightClassException(int weight){
        super("No weight class at " + weight + " pounds");
    }

    public InvalidWeightClassException(String weight){
        super("Weight must be integer");
    }
}
