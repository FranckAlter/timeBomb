package fr.esgi.timebomb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    public Player() {

    }
//    private List<Card> cards;

}
