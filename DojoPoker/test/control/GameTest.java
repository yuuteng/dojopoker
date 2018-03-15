package control;


import model.Card;
import model.Rank;
import model.Suit;
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
    @Test
    void addPlayer1Card() {
        Game game = new Game();
        Card card = new Card(Rank.FIVE, Suit.CLUBS);
        game.addPlayer1Card(card);
        Card expected = card;
        Card actual = game.getPlayer1().getCards().get(0);
        assertEquals(actual,expected);
    }

    @Test
    void addPlayer2Card() {
        Game game = new Game();
        Card card = new Card(Rank.FIVE, Suit.CLUBS);
        game.addPlayer2Card(card);
        Card expected = card;
        Card actual = game.getPlayer2().getCards().get(0);
        assertEquals(actual,expected);
    }

    //1:2
    @Test
    void compareHighCard1Win() {
        Game game = new Game();
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

    //1:1
    @Test
    void compareHighCardEqual() {
        Game game = new Game();
        int actual = -1;
        Card card1 = new Card(Rank.ACE,Suit.CLUBS);
        Card card2 = new Card(Rank.ACE,Suit.CLUBS);
        List<Card> cardlist1 = new ArrayList<Card>();
        List<Card> cardlist2 = new ArrayList<Card>();
        cardlist1.add(card1);
        cardlist2.add(card2);
        Map<String, List<Card>> actualMap = game.compareHighCard(cardlist1, cardlist2);
        Map<String, List<Card>> expectedMap = new HashMap<>();
        expectedMap.put("0", cardlist1);
        int expected = 0;
        if (actualMap.keySet().contains("0")){
             actual = 0;
        }
        assertEquals(actual,expected);
    }

    //55:44
    @Test
    void comparePairPlayer1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.comparePair();
        assertEquals(actual,expected);
    }

    //55:66
    @Test
    void comparePairPlayer2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 2;
        int actual = game.comparePair();
        assertEquals(actual,expected);
    }

    //55:55
    @Test
    void comparePairEqual() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.SPADES));
        int expected = 0;
        int actual = game.comparePair();
        assertEquals(actual,expected);
    }

    //57:64
    @Test
    void comparePairNoPair() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.SPADES));
        int expected = 0;
        int actual = game.comparePair();
        assertEquals(actual,expected);
    }

    //55:64
    @Test
    void comparePairOnePair() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.SPADES));
        int expected = 1;
        int actual = game.comparePair();
        assertEquals(actual,expected);
    }

    //555:444
    @Test
    void compareThree1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareThree();
        assertEquals(actual,expected);
    }
    //555:666
    @Test
    void compareThree2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 2;
        int actual = game.compareThree();
        assertEquals(actual,expected);
    }

    //456:789
    @Test
    void compareThreeNoThree() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.DIAMONDS));
        int expected = 0;
        int actual = game.compareThree();
        assertEquals(actual,expected);
    }

    //55522:44433
    @Test
    void compareFull1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareFull();
        assertEquals(actual,expected);
    }
    //55522:66633
    @Test
    void compareFull2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 2;
        int actual = game.compareFull();
        assertEquals(actual,expected);
    }

    //45622:78922
    @Test
    void compareFullNoFull() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 0;
        int actual = game.compareFull();
        assertEquals(actual,expected);
    }

    //55552:44443
    @Test
    void compareFour1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareFour();
        assertEquals(actual,expected);
    }
    //55552:66663
    @Test
    void compareFour2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 2;
        int actual = game.compareFour();
        assertEquals(actual,expected);
    }

    //45622:78922
    @Test
    void compareFourNoFour() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        int expected = 0;
        int actual = game.compareFour();
        assertEquals(actual,expected);
    }

    //34567 spades:23456  diamonds
    @Test
    void compareSuit1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareSuit();
        assertEquals(actual,expected);
    }
    //23456 clubs :34567 hearts
    @Test
    void compareSuit2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        int expected = 2;
        int actual = game.compareSuit();
        assertEquals(actual,expected);
    }

    //23456 clubs :23456 hearts
    @Test
    void compareSuitEqual() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.TWO,Suit.HEARTS));
        int expected = 0;
        int actual = game.compareSuit();
        assertEquals(actual,expected);
    }

    //13456 :34568
    @Test
    void compareSuitNoSuit() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.ACE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.CLUBS));
        int expected = 0;
        int actual = game.compareColor();
        assertEquals(actual,expected);
    }

    //34567 spades:23456  diamonds
    @Test
    void compareColor1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareColor();
        assertEquals(actual,expected);
    }
    //23456 clubs :34567 hearts
    @Test
    void compareColor2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        int expected = 2;
        int actual = game.compareColor();
        assertEquals(actual,expected);
    }

    //2345 clubs 6 HEARTS:3456 hearts 7 CLUBS
    @Test
    void compareColorNoColor() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.CLUBS));
        int expected = 0;
        int actual = game.compareColor();
        assertEquals(actual,expected);
    }

    //34567 spades:34567  diamonds
    @Test
    void compareColorEqual() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 0;
        int actual = game.compareColor();
        assertEquals(actual,expected);
    }

    //55667:44557
    @Test
    void compareTwoPair1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.SPADES));
        int expected = 1;
        int actual = game.compareTwoPair();
        assertEquals(actual,expected);
    }

    //55667:77889
    @Test
    void compareTwoPairPlayer2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.SPADES));
        int expected = 2;
        int actual = game.compareTwoPair();
        assertEquals(actual,expected);
    }

    //55667:55669
    @Test
    void compareTwoPairEqual() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.SPADES));
        int expected = 0;
        int actual = game.compareTwoPair();
        assertEquals(actual,expected);
    }

    //23456 clubs :34567 hearts
    @Test
    void compareTwoPairNoPair() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        int expected = 0;
        int actual = game.compareTwoPair();
        assertEquals(actual,expected);
    }

    //34567 spades:23456  diamonds
    @Test
    void compareFlush1Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.THREE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.SEVEN,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.TWO,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.DIAMONDS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.DIAMONDS));
        int expected = 1;
        int actual = game.compareFlush();
        assertEquals(actual,expected);
    }
    //23456 clubs :34567 hearts
    @Test
    void compareFlush2Win() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        int expected = 2;
        int actual = game.compareFlush();
        assertEquals(actual,expected);
    }

    //2345 clubs 6 HEARTS:3456 hearts 7 CLUBS
    @Test
    void compareFlushNoFlush() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.CLUBS));
        int expected = 0;
        int actual = game.compareFlush();
        assertEquals(actual,expected);
    }
    //23456 clubs:23456 HEARTS
    @Test
    void compareFlushEqual() {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.TWO,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.SIX,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.TWO,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.THREE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FOUR,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.FIVE,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        int expected = 0;
        int actual = game.compareFlush();
        assertEquals(actual,expected);
    }

}