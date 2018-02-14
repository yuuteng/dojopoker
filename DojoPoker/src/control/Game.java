package control;

import model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * A class control.Game to play a game of cards.
 The constructor receives as argument the names of players and instantiates them. There may be two or more players.
 In one round of the game, each player draws a card from his deck; the player with the highest card wins a point. No points awarded for a tie.
 The game ends when there are no more cards left.
 The player with the most points wins.
 */
public class Game {
    private List<Player> players;

    public Game() {
        players = new ArrayList<Player>();
    }

    public Game(String... names){
        players = new ArrayList<Player>();

        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i]));
        }
    }

    void addPlayer(Player player) {
        players.add(player);
    }

    int getPlayersNum() {
        return players.size();
    }

    void showAllPlayers() {
        System.out.println("Num: " + getPlayersNum());
        for (Player player : players) {
            System.out.println("Name:" + player.name
                    + " Points:" + player.points);
        }
    }

    void oneTurn() {
        //every turn the cards of players
        List<Card> cards = new ArrayList<Card>();
        for (Player player : players) {
            Card tmpCard = player.deck.draw();
            cards.add(tmpCard);
            //show control.Player and card
            System.out.println("Name:" + player.name
                    + " Points:" + player.points);
            System.out.println(tmpCard);
        }

        //Compare
        Card maxCard = cards.get(0);
        int maxIndex = 0;
        int flag = 0; //Tie:0 ; not tie 1

        for (int i = 1; i < cards.size(); i++) {
            switch (maxCard.compare(cards.get(i))) {
                case 1:
                    flag = 1;
                    break;
                case 0:
                    flag = 0;
                    break;
                case -1:
                    maxCard = cards.get(i);
                    maxIndex = i;
                    flag = 1;
                    break;
            }
        }

        if (flag == 1) {
            players.get(maxIndex).addPoints();
            System.out.println(players.get(maxIndex).name
                    + " win! And now his point is "
                    + players.get(maxIndex).points);
        } else {
            System.out.println("No one win the point!");
        }
    }

    void endGame() {
        for (int i = 1; i <= 52; i++) {

            System.out.println("---------------------");

            System.out.println("Turn: " + i);
            oneTurn();

        }
        System.out.println("---------------------");

        showAllPlayers();
        System.out.println("---------------------");

        showResult();
    }

    void showResult() {
        Player winnerPlayer = players.get(0);
        //if the point is tie
        List<Player> winnerPlayers = new ArrayList<Player>();
        winnerPlayers.add(winnerPlayer);
        for (int i = 1; i < players.size(); i++) {
            switch (winnerPlayer.compareWith(players.get(i))) {
                case 1:
                    break;
                case 0:
                    //if tie with members in list then add new
                    //else remove all in the list and add new menbers
                    if (winnerPlayers.get(0).compareWith(players.get(i)) == 0) {
                        winnerPlayers.add(players.get(i));
                    }else {
                        winnerPlayers.clear();
                        winnerPlayers.add(winnerPlayer);
                        winnerPlayers.add(players.get(i));
                    }
                    break;
                case -1:
                    winnerPlayer = players.get(i);
                    winnerPlayers.clear();
                    winnerPlayers.add(winnerPlayer);
                    break;
            }
        }
        for (int i=0;i<winnerPlayers.size();i++) {
            System.out.println(winnerPlayers.get(i).name+" is the winner"
                    + ". His point is " + winnerPlayers.get(i).points);
        }
    }
}
