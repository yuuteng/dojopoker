package control;

import model.Card;
import model.Deck;
import model.Player;

import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    public Game() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        deck = new Deck();
        deck.shuffle();
        //one card
        for(int i=0;i<1;i++) {
            player1.addCard(deck.draw());
            player2.addCard(deck.draw());
        }
    }

    public void show(){
        System.out.println("Name: " + player1.getName());
        player1.showAllCard();
        System.out.println("Name: " + player2.getName());
        player2.showAllCard();
    }

    public void compare() {
        List<Card> handCards1 = player1.getCards();
        List<Card> handCards2 = player2.getCards();
        int result = -1;
        result = compareHighCard(handCards1,handCards2);
        switch (result) {
            case 1:
                System.out.println("player1 win");
                break;
            case 2:
                System.out.println("player2 win");
                break;
            default:
                System.out.println("Equal");
                break;
        }
    }

    // 0 equal 1 p1win  2 p2win
    public int compareHighCard(List<Card> handCards1, List<Card> handCards2) {
        Card card1 = handCards1.get(0);
        Card card2 = handCards2.get(0);
        if (card1.getValue() > card2.getValue()) {
             return 1;
        } else if (card1.getValue() < card2.getValue()) {
            return 2;
        } else {
            return 0;
        }
    }
}
