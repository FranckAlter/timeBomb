package com.esgi.timebomb.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private enum State {
        MORIARTY_WIN, SHERLOCK_WIN, IN_GAME
    }

    private int id;
    private int step;
    private int round;
    private int color_find;
    private List<Player> players;
    private State state;
    private Player next_player;

    public Game (int id, List<Player> players) {
        this.id = id;
        this.players = players;
        this.step = 1;
        this.round = 1;
        this.color_find = 0;
        this.next_player = players.get(0);
        this.state = State.IN_GAME;
        init_cards();
    }

    private void init_cards(){
        for (Player player : this.players) {
            player.getCards().clear();
        }
        int remaining_color = players.size() - this.color_find;
        List<Card> cards = new ArrayList<>();
        for (int i=0; i< remaining_color; i++) {
            Card card = new Card (Card.Value.COLOR);
            cards.add(card);
        }
        cards.add(new Card (Card.Value.BOMB));
        int remaining_ordinary = (players.size() * (6-step)) - (1 + remaining_color);
        for (int i=0; i< remaining_ordinary; i++) {
            Card card = new Card (Card.Value.ORDINARY);
            cards.add(card);
        }
        Collections.shuffle(cards);
        int count_player = 0;
        for (Card card : cards) {
            this.players.get(count_player%players.size()).getCards().add(card);
            count_player += 1;
        }

    }
    public Game move (Move move) {
        this.next_player = move.getPlayer();
        if (move.getCard().getValue() == Card.Value.BOMB) {
            this.state = State.MORIARTY_WIN;
            return this;
        }
        else {
            if (move.getCard().getValue() == Card.Value.COLOR) {
                this.color_find += 1;
                if (color_find == players.size()) {
                    this.state = State.SHERLOCK_WIN;
                    return this;
                }
            }
            this.round += 1;
            if (this.round == players.size() + 1) {
                change_step();
            }
            return this;
        }
    }

    private void change_step () {
        this.step += 1;
        if (this.step == 5) {
            this.state = State.MORIARTY_WIN;
        }
        else {
            this.round = 1;
            init_cards();
        }
    }
}
