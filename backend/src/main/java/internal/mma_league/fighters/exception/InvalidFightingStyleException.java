package internal.mma_league.fighters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "no fighting style with that name")
public class InvalidFightingStyleException extends RuntimeException{
    public InvalidFightingStyleException(String message){
        super(message);
    }
}
