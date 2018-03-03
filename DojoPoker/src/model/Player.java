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

    public void addCard(Card card) {
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
    public void handleCards() {
        Collections.sort(handCards);
        Collections.reverse(handCards);
    }

    //the num of pair (have)  0 don't have
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

    //the num of three (have)  0 don't have
    public int haveThree() {
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                if (handCards.get(i).getValue() == handCards.get(j).getValue()) {
                    for (int k = j + 1; k < handCards.size(); k++) {
                        if (handCards.get(j).getValue() == handCards.get(k).getValue()) {
                            return handCards.get(i).getValue();
                        }
                    }
                }
            }
        }
        return 0;
    }

    //the num of four (have) 0 don't have
    public int haveFour() {
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                if (handCards.get(i).getValue() == handCards.get(j).getValue()) {
                    for (int k = j + 1; k < handCards.size(); k++) {
                        if (handCards.get(j).getValue() == handCards.get(k).getValue()) {
                            for (int l = k + 1; l < handCards.size(); l++) {
                                if (handCards.get(k).getValue() == handCards.get(l).getValue()) {
                                    return handCards.get(i).getValue();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    //if have suit
    public int haveSuit() {
        return 0;
    }
}
