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
class DeckTest {
    static Deck deck;

    @BeforeAll
    static void setUp() {
        deck = new Deck();
    }

    @Test
    void draw() {
        Card expected = new Card(Rank.ACE);
        Card actual = deck.draw();
        assertEquals(expected.getValue(), actual.getValue());
    }
}