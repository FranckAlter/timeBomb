package com.esgi.timebomb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {

    public enum Value {
        COLOR, ORDINARY, BOMB
    }

    @Id
    @GeneratedValue
    private String id;
    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public Card(String id, Value value) {
        this.id = id;
        this.value = value;
    }

    public Card() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
