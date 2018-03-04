package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank,suit));
            }
        }

    }

    //put the cards into a random order
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    //select the top card of the deck;
    //that card is removed from the deck
    public Card draw(){
        if (cards.size() < 1) {
            return null;
        }
        return cards.remove(0);
    }

}
