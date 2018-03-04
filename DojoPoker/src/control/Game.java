package control;

import com.sun.org.apache.regexp.internal.REUtil;
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
        //three card
        for (int i = 0; i < 5; i++) {

            player1.addCard(deck.draw());
            player2.addCard(deck.draw());
        }
        player1.handleCards();
        player2.handleCards();
    }

    public void show(){
        System.out.print("Main1: ");
        player1.showAllCard();
        System.out.print("Main2: ");
        player2.showAllCard();
    }

    public void compare() {
        List<Card> handCards1 = player1.getCards();
        List<Card> handCards2 = player2.getCards();
        int result = -1;
        String comment = "";
        if (player1.haveFlush() > 0 || player2.haveFlush() > 0) {
            result = compareFlush();
            comment = "quinte flush";
        } else if (player1.haveFour() > 0 || player2.haveFour() > 0) {
            result = compareFour();
            comment = "carré";
        }
        //full
        else if (player1.haveSameColor() > 0 || player2.haveSameColor() > 0) {
            result = compareColor();
            comment = "couleur";
        } else if (player1.haveSuit() > 0 || player2.haveSuit() > 0) {
            result = compareSuit();
            comment = "suite";
        } else if (player1.haveThree() > 0 || player2.haveThree() > 0) {
            result = compareThree();
            comment = "brelan";
        } else if (player1.haveTwoPair() != null || player2.haveTwoPair() != null) {
            result = compareTwoPair();
            comment = "deux paire";
        } else if (player1.havePair() > 0 || player2.havePair() > 0) {
            result = comparePair();
            comment = "paire";
        } else {
            result = compareHighCard(handCards1, handCards2);
            comment = "carte la plus élevée";
        }
        switch (result) {
            case 1:
                System.out.println("La main 1 gagne avec " + comment + " win");
                break;
            case 2:
                System.out.println("La main 1 gagne avec " + comment + " win");
                break;
            default:
                System.out.println("Egalite");
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
    // 0 equal 1 p1win  2 p2win
    public int comparePair() {
        if (player1.havePair() == player2.havePair()) {
            return 0;
        } else if (player1.havePair() > player2.havePair()) {
            return 1;

        } else {
            return 2;
        }
    }
    // 0 equal 1 p1win  2 p2win
    public int compareThree() {
        if (player1.haveThree() == player2.haveThree()) {
            return 0;
        } else if (player1.haveThree() > player2.haveThree()) {
            return 1;

        } else {
            return 2;
        }
    }
    // 0 equal 1 p1win  2 p2win
    public int compareFour(){
        if (player1.haveFour() == player2.haveFour()) {
            return 0;
        }else if (player1.haveFour() > player2.haveFour()) {
            return 1;

        }else{
            return 2;
        }
    }

    // 0 equal 1 p1win  2 p2win
    public int compareSuit(){
        if (player1.haveSuit() == player2.haveSuit()) {
            return 0;
        }else if (player1.haveSuit() > player2.haveSuit()) {
            return 1;

        }else{
            return 2;
        }
    }

    // 0 equal 1 p1win  2 p2win
    public int compareColor(){
        if (player1.haveSameColor() == player2.haveSameColor()) {
            return 0;
        }else if (player1.haveSameColor() > player2.haveSameColor()) {
            return 1;

        }else{
            return 2;
        }
    }

    // 0 equal 1 p1win  2 p2win
    public int compareTwoPair(){
        List<Card> player1Pair = player1.haveTwoPair();
        List<Card> player2Pair = player2.haveTwoPair();

        if (player1Pair != null && player2Pair == null) {
            //player 1 have two pair ,player 2 dont have
            return 1;
        } else if (player1Pair == null && player2Pair != null) {
            //player 2 have two pair ,player 1 dont have
            return 2;
        } else {
            //player1 and 2 both have two pair
            if (player1Pair.get(0).getValue() > player2Pair.get(0).getValue()) {
                return 1;
            } else if (player1Pair.get(0).getValue() < player2Pair.get(0).getValue()) {
                return 2;
            } else {
                //first pair is equal
                if (player1Pair.get(1).getValue() > player2Pair.get(1).getValue()) {
                    return 1;
                } else if (player1Pair.get(1).getValue() < player2Pair.get(1).getValue()) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    // 0 equal 1 p1win  2 p2win
    public int compareFlush(){
        if (player1.haveFlush() == player2.haveFlush()) {
            return 0;
        }else if (player1.haveFlush() > player2.haveFlush()) {
            return 1;

        }else{
            return 2;
        }
    }
}
