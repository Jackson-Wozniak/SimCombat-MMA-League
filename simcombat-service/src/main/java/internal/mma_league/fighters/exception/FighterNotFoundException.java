package internal.mma_league.fighters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "cannot find fighter")
public class FighterNotFoundException extends RuntimeException{
    public FighterNotFoundException(String message){
        super(message);
    }
}
