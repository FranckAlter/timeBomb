package fr.esgi.timebomb.dto;

import fr.esgi.timebomb.domain.Card;
import lombok.Data;

import java.util.List;

@Data
public class LoginDTO {
    private String username;
    private String password;
//    private List<Card> cards;
}
