package control;

import model.Deck;
import model.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    public Game() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        deck = new Deck();
        deck.shuffle();
        for(int i=0;i<2;i++) {
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
