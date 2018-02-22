package model;

public class Card {
    Rank rank;

    public Card(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card: "+rank.getName();
    }

    public int getValue() {
        return rank.getValue();
    }
}
