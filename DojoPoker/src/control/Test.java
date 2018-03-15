package control;

import model.Card;
import model.Rank;
import model.Suit;

/**
 * @Project: DojoPoker
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class Test {
    public static void main(String... args) {
        Game game = new Game();
        game.addPlayer1Card(new Card(Rank.ACE,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.TWO,Suit.SPADES));
        game.addPlayer1Card(new Card(Rank.THREE,Suit.DIAMONDS));
        game.addPlayer1Card(new Card(Rank.FOUR,Suit.CLUBS));
        game.addPlayer1Card(new Card(Rank.FIVE,Suit.CLUBS));
        game.addPlayer2Card(new Card(Rank.SIX,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.SEVEN,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.EIGHT,Suit.SPADES));
        game.addPlayer2Card(new Card(Rank.NIGHT,Suit.HEARTS));
        game.addPlayer2Card(new Card(Rank.TEN,Suit.HEARTS));
        game.show();
        game.compare();

    }
}
