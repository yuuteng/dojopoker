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
class CardTest {
    static Card card1;
    static Card card2;
    static Card card3;
    @BeforeAll
    static void setUp() {
        card1 = new Card(Rank.ACE);
        card2 = new Card(Rank.FIVE);

        card3 = new Card(Rank.EIGHT, Suit.CLUBS);
    }
    @Test
    void compareTo() {
        int actual = card1.compareTo(card2);
        int expected = 1;
        assertEquals(expected, actual);
    }
}