package model;

public enum Suit {
    CLUBS("Tr"),DIAMONDS("Ca"),
    HEARTS("Co"),SPADES("Pi");
    private final String name;
    Suit(String name) {
        this.name = name;

    }
    String getName() {
        return name;
    }

}
