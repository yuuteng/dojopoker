package model;

//clubs < diamonds < hearts < spades
public enum Suit {
    CLUBS("clubs",1),DIAMONDS("diamonds",2),
    HEARTS("hearts",3),SPADES("spades",4);
    private final String name;
    private final int value;

    Suit(String name, int value) {
        this.name = name;
        this.value = value;
    }
    String getName() {
        return name;
    }

    int getValue() {
        return value;
    }
}
