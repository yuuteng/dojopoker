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
    static Player player;

    @BeforeAll
    static void setUp() {
        player = new Player("player");
    }

    @Test
    void getName() {
        String actual = player.getName();
        String expected = "player";
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfHand() {
        player.addCard(new Card(Rank.FIVE));
        int expected = 1;
        int actual = player.getNumberOfHand();
        assertEquals(expected, actual);
    }

    @Test
    void havePair() {
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        int expected = 5;
        int actual = player.havePair();
        assertEquals(expected, actual);
    }

    @Test
    void haveThree() {
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        player.addCard(new Card(Rank.FIVE));
        int expected = 5;
        int actual = player.haveThree();
        assertEquals(expected, actual);
    }

    @Test
    void haveSuit() {
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
}