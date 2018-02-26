package control;


import model.Card;
import model.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Project: DojoPoker
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
class GameTest {
    static Game game;
    @BeforeAll
    static void setUp() {
        game = new Game();
    }

    @Test
    void compareHighCard() {
        Card card1 = new Card(Rank.ACE);
        Card card2 = new Card(Rank.TWO);
        List<Card> cardlist1 = new ArrayList<Card>();
        List<Card> cardlist2 = new ArrayList<Card>();
        cardlist1.add(card1);
        cardlist2.add(card2);
        int actual = game.compareHighCard(cardlist1, cardlist2);
        int expected = 1;
        assertEquals(actual,expected);
    }

    @Test
    void comparePair() {
        Card card1 = new Card(Rank.FOUR);
        Card card2 = new Card(Rank.TWO);
        List<Card> handCards1 = new ArrayList<Card>();
        List<Card> handCards2 = new ArrayList<Card>();
        handCards1.add(card1);
        handCards1.add(card1);
        handCards2.add(card2);
        handCards2.add(card2);
        boolean actual = handCards1.get(0).getValue() > handCards2.get(0).getValue();
        boolean expected = true;
        assertEquals(actual,expected);
    }
}