package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project: DojoPoker
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
class PlayerTest {

    @Test
    void getName() {
        Player player;
        player = new Player("player");
        String actual = player.getName();
        String expected = "player";
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfHand() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.FIVE));
        int expected = 1;
        int actual = player.getNumberOfHand();
        assertEquals(expected, actual);
    }

    @Test
    void addCard() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.SIX));
        int expected = 6;
        int actual = player.getCards().get(0).getValue();
        assertEquals(expected, actual);
    }
    @Test
    void havePair() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        int expected = 5;
        int actual = player.havePair();
        assertEquals(expected, actual);
    }

    @Test
    void haveThree() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        int expected = 5;
        int actual = player.haveThree();
        assertEquals(expected, actual);
    }

    @Test
    void haveFull() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.TWO));
        player.addCard(new Card(Rank.TWO));
        int expected = 5;
        int actual = player.haveFull();
        assertEquals(expected, actual);
    }

    @Test
    void haveSuit() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.TWO));
        player.addCard(new Card(Rank.THREE));
        player.addCard(new Card(Rank.FOUR));
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.SIX));
        player.handleCards();
        int expected = 6;
        int actual = player.haveSuit();
        assertEquals(expected, actual);
    }

    @Test
    void haveSameColor() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.TWO, Suit.CLUBS));
        player.addCard(new Card(Rank.THREE, Suit.CLUBS));
        player.addCard(new Card(Rank.FOUR, Suit.CLUBS));
        player.addCard(new Card(Rank.FIVE, Suit.CLUBS));
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.handleCards();
        int expected = 6;
        int actual = player.haveSameColor();
        assertEquals(expected, actual);
    }
    @Test
    void haveTwoPaire() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.TWO));
        player.addCard(new Card(Rank.TWO));
        player.addCard(new Card(Rank.FOUR));
        player.addCard(new Card(Rank.FOUR));
        player.handleCards();
        List<Card> testList = player.haveTwoPair();
        int expected = 2;
        int actual = testList.get(1).getValue();
        assertEquals(expected, actual);
    }

    @Test
    void haveFlush() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.TWO, Suit.CLUBS));
        player.addCard(new Card(Rank.THREE, Suit.CLUBS));
        player.addCard(new Card(Rank.FOUR, Suit.CLUBS));
        player.addCard(new Card(Rank.FIVE, Suit.CLUBS));
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.handleCards();
        int expected = 6;
        int actual = player.haveFlush();
        assertEquals(expected, actual);
    }

    @Test
    void haveFour() {
        Player player;
        player = new Player("player");
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.addCard(new Card(Rank.SIX, Suit.CLUBS));
        player.handleCards();
        int expected = 6;
        int actual = player.haveFour();
        assertEquals(expected, actual);
    }
}