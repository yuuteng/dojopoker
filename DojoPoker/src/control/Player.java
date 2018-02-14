package control;

/**
 * A class control.Player representing a card player.
 A player has a deck of cards (ordered) passed as an argument in the constructor.
 The player shuffles his cards.
 The player has an attribute points indicating how many points he currently has.
 */
public class Player {
    String name;
    Deck deck;
    int points;
    //deck ordered
    public Player(String name) {
        this.name = name;
        deck = new Deck();
        deck.shuffle();
        points = 0;
    }

    void addPoints() {
        points++;
    }
    int getPoints() {
        return points;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    //Compare the points of control.Player
    //this=player return 0; > return 1; < return -1
    public int compareWith(Player player) {
        if (this.points == player.points) {
            return 0;
        } else if (this.points > player.points) {
            return 1;
        } else {
            return -1;
        }
    }
}
