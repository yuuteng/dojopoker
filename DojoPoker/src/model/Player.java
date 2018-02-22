package model;

import java.util.ArrayList;
import java.util.Collections;
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
    //sort all cards
    public void handleCards(){
        Collections.sort(handCards);
        Collections.reverse(handCards);
    }

    //the num of pair (have)  0 dont have
    public int havePair() {
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                if (handCards.get(i).getValue() == handCards.get(j).getValue()) {
                    return handCards.get(i).getValue();
                }
            }
        }
        return 0;
    }
}
