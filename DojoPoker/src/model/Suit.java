package model;

public enum Suit {
    CLUBS("clubs"),DIAMONDS("diamonds"),
    HEARTS("hearts"),SPADES("spades");
    private final String name;
    Suit(String name) {
        this.name = name;

    }
    String getName() {
        return name;
    }

}
