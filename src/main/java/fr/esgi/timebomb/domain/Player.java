package fr.esgi.timebomb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name="roles")
    private List<String> roles = new ArrayList<String>();
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Card> cards;

    public Player(String username, String password, List<String> roles, List<Card> cards) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.cards = cards;
    }

    public Player() {

    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}



