package fr.esgi.timebomb.domain;


public class Card {
    public enum Value {
        COLOR, ORDINARY, BOMB
    }
    private Value value;

    public Card (Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
