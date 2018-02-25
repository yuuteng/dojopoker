package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        int expected = 5;
        int actual = player.havePair();
        assertEquals(expected, actual);
    }

    @Test
    void haveThree() {
        player.addCard(new Card(Rank.FIVE));
        int expected = 5;
        int actual = player.havePair();
        assertEquals(expected, actual);
    }
}