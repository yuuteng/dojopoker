package model;

public enum Rank {

    ACE("A",14),TWO("2",2),THREE("3",3),
    FOUR("4",4),FIVE("5",5),SIX("6",6),
    SEVEN("7",7),EIGHT("8",8),NIGHT("9",9),
    TEN("10",10),JACK("V",11),
    QUEEN("D",12),KING("R",13);


    private final String name;
    private final int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    int getValue() {
        return value;
    }
}
