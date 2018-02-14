package control;

import model.Card;
import model.Rank;
import model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * A class control.Deck which represents all 52 cards of a normal deck of cards.
 The cards in the deck are initially in order.
 There is a method shuffle to put the cards into a random order.
 There is a method draw to select the top card of the deck; that card is removed from the deck.
 */
public class Deck {
    List<Card> cards;

    //initially in order
    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    //put the cards into a random order
    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    //select the top card of the deck;
    //that card is removed from the deck
    Card draw(){
        if (cards.size() < 1) {
            return null;
        }
        return cards.remove(0);
    }
}
