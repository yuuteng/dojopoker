package model;

public class Card {
    private static final int BIG = 1;
    private static final int SMALL = -1;
    private static final int TIE = 0;
    Rank rank;
    Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank.getName() + " of " + suit.getName();
    }

    //big 1
    //small -1
    //tie 0
    public int compare(Card card) {
        if (rank.getValue() > card.rank.getValue()) {
            return BIG;
        } else if (rank.getValue() < card.rank.getValue()) {
            return SMALL;
        }else {
            if (suit.getValue() > card.suit.getValue()) {
                return BIG;
            }else if(suit.getValue()<card.suit.getValue()){
                return SMALL;
            }else {
                return TIE;
            }
        }
    }
}
