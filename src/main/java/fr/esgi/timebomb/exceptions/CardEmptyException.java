package fr.esgi.timebomb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardEmptyException extends Throwable {
    public CardEmptyException(String message) {
        super(message);
    }
}
