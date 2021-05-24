package fr.esgi.timebomb.request;

import fr.esgi.timebomb.domain.Card;
import lombok.Data;

@Data
public class CreateCardRequest {
    private Card.Value value;
}
