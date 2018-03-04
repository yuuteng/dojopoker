package model;


public class Card implements Comparable{
    Rank rank;
    Suit suit;

    public Card(Rank rank) {
        this.rank = rank;
    }
    public Card(Rank rank,Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card: "+rank.getName()+" "+ suit.getName();
    }

    public int getValue() {
        return rank.getValue();
    }
    @Override
    public int compareTo(Object o) {
        if(rank.getValue()>((Card) o).getValue()){
            return 1;
        }else if (rank.getValue()<((Card) o).getValue()){
            return -1;
        }else {
            return 0;
        }
    }
}
