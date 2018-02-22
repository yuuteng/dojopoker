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


}
