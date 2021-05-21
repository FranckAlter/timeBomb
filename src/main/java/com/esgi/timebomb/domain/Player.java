package com.esgi.timebomb.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String discord_id;
    private List<Card> cards;

    public Player (int id, String discord_id) {
        this.id = id;
        this.discord_id = discord_id;
        this.cards = new ArrayList<Card>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscord_id() {
        return discord_id;
    }

    public void setDiscord_id(String discord_id) {
        this.discord_id = discord_id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
