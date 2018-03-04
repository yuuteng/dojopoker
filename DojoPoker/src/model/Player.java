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
        String str = "";
        for (Card card : handCards) {
            str = str + card + " ";
        }
        System.out.println(str);
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
        if (handCards.get(0).getValue() == handCards.get(1).getValue() + 1
                && handCards.get(1).getValue() == handCards.get(2).getValue() + 1
                && handCards.get(2).getValue() == handCards.get(3).getValue() + 1
                && handCards.get(3).getValue() == handCards.get(4).getValue() + 1) {

            return handCards.get(0).getValue();
        }
        return 0;
    }
    //if have suit
    public int haveSameColor() {
        if (handCards.get(0).getSuit() == handCards.get(1).getSuit()
                && handCards.get(1).getSuit() == handCards.get(2).getSuit()
                && handCards.get(2).getSuit() == handCards.get(3).getSuit()
                && handCards.get(3).getSuit() == handCards.get(4).getSuit()) {

            return handCards.get(0).getValue();
        }
        return 0;
    }

    //have deux paire
    public List<Card> haveTwoPair() {
        List<Card> pairList = new ArrayList<Card>();
        for (int i = 0; i < handCards.size(); i++) {
            for (int j = i + 1; j < handCards.size(); j++) {
                if (handCards.get(i).getValue() == handCards.get(j).getValue()) {
                    pairList.add(handCards.get(i)) ;
                }
            }
        }
        if (pairList.size() == 2) {
            return pairList;
        }
        return null;
    }

    //have flush
    public int haveFlush() {
        int maxNum = haveSuit();
        if (maxNum > 0 && haveSameColor() > 0) {
            return maxNum;
        }
        return 0;
    }
}
