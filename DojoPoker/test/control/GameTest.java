package control;

import model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project: DojoPoker
 * @Author: YU Teng
 * @Description:
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
    void testCompareHighCard() {
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
}