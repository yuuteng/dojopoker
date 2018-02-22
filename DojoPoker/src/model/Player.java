package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Card> handCards;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<Card>();
    }

    public void addCard(Card card){
        handCards.add(card);
    }

    public void showAllCard() {
        for (Card card : handCards) {
            System.out.println(card);
        }

    }

    public int getNumberOfHand() {
        return handCards.size();
    }
    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return handCards;
    }
}
