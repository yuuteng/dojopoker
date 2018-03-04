package control;


import model.Card;
import model.Player;
import model.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, List<Card>> actual = game.compareHighCard(cardlist1, cardlist2);
        Map<String, List<Card>> expected = new HashMap<>();
        expected.put("1", cardlist1);
        assertEquals(actual,expected);
    }

    // Little problems, need to be solved
    @Test
    void comparePair() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Card card1 = new Card(Rank.FIVE);
        Card card2 = new Card(Rank.TWO);
        player1.addCard(card1);
        player1.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        int actual = game.comparePair();
        int expected = 1;
        assertEquals(actual,expected);
    }

    @Test
    void havePair() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Card card1 = new Card(Rank.FIVE);
        Card card2 = new Card(Rank.TWO);
        player1.addCard(card1);
        player1.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        boolean actual = player1.havePair() > 1 && player1.havePair() >0;
        boolean expected = true;
        assertEquals(actual,expected);
    }

    // Little problems, need to be solved
    @Test
    void compareThree() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Card card1 = new Card(Rank.FIVE);
        Card card2 = new Card(Rank.TWO);
        player1.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        player2.addCard(card2);
        int actual = game.compareThree();
        int expected = 1;
        assertEquals(actual,expected);
    }

    @Test
    void haveThree() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Card card1 = new Card(Rank.FIVE);
        Card card2 = new Card(Rank.TWO);
        player1.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card2);
        player2.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        player2.addCard(card2);
        boolean actual = player1.haveThree() > 1 && player1.haveThree() >0;
        boolean expected = true;
        assertEquals(actual,expected);
    }

    @Test
    void haveFour() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Card card1 = new Card(Rank.FIVE);
        Card card2 = new Card(Rank.TWO);
        player1.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card1);
        player2.addCard(card2);
        player2.addCard(card2);
        player2.addCard(card2);
        boolean actual = player1.haveFour() > 1 && player1.haveFour() >0;
        boolean expected = true;
        assertEquals(actual,expected);
    }

}