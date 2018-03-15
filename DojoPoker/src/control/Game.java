package control;

import model.Card;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("player1");
        player2 = new Player("player2");
    }
    public void addPlayer1Card(Card card) {
        player1.addCard(card);
        player1.handleCards();
    }
    public void addPlayer2Card(Card card) {
        player2.addCard(card);
        player2.handleCards();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
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
        Map<String, List<Card>> resMap = new HashMap<>();
        int result = -1;
        String comment = "";
        if (player1.haveFlush() > 0 || player2.haveFlush() > 0) {
            result = compareFlush();
            comment = "quinte flush fin de ";
            if (result == 1) {
                comment += matchCard(player1.haveFlush());
            } else {
                comment += matchCard(player2.haveFlush());
            }
        } else if (player1.haveFour() > 0 || player2.haveFour() > 0) {
            result = compareFour();
            comment = "carré de ";
            if (result == 1) {
                comment += matchCard(player1.haveFour());
            } else {
                comment += matchCard(player2.haveFour());
            }
        }else if (player1.haveFull() > 0 || player2.haveFull() > 0) {
            result = compareFull();
            comment = "full de trois ";
            if (result == 1) {
                comment += matchCard(player1.haveFull());
            } else {
                comment += matchCard(player2.haveFull());
            }
        } else if (player1.haveSameColor() > 0 || player2.haveSameColor() > 0) {
            result = compareColor();
            comment = "couleur de ";
            if (result == 1) {
                comment += player1.getCards().get(0);
            } else {
                comment += player2.getCards().get(0);
            }
        } else if (player1.haveSuit() > 0 || player2.haveSuit() > 0) {
            result = compareSuit();
            comment = "suite de ";
            if (result == 1) {
                for (int i = 0;i<5;i++) {
                    comment += matchCard(player1.haveSuit() - i)+" ";
                }
            } else {
                for (int i = 0;i<5;i++) {
                    comment += matchCard(player2.haveSuit() - i)+" ";
                }
            }
        } else if (player1.haveThree() > 0 || player2.haveThree() > 0) {
            result = compareThree();
            comment = "brelan de ";
            if (result == 1) {
                comment += matchCard(player1.haveThree());
            } else {
                comment += matchCard(player2.haveThree());
            }
        } else if (player1.haveTwoPair() != null || player2.haveTwoPair() != null) {
            result = compareTwoPair();
            comment = "deux paire de ";
            List<Card> listTmp;
            if (result == 1) {
                listTmp = player1.haveTwoPair();
                comment += matchCard(listTmp.get(0).getValue()) +" et " +matchCard(listTmp.get(1).getValue());
            } else {
                listTmp = player2.haveTwoPair();
                comment += matchCard(listTmp.get(0).getValue()) +" et " +matchCard(listTmp.get(1).getValue());
            }
        } else if (player1.havePair() > 0 || player2.havePair() > 0) {
            result = comparePair();
            comment = "paire de ";
            if (result == 1) {
                comment += matchCard(player1.havePair());
            } else {
                comment += matchCard(player2.havePair());
            }
        } else {
            comment = "carte la plus élevée : ";
            resMap = compareHighCard(handCards1, handCards2);
                for (Map.Entry<String, List<Card>> entry : resMap.entrySet()) {
                    switch (entry.getKey()) {
                        case "1":
                            comment += matchCard(entry.getValue().get(0).getValue());
                            result = 1;
                            break;
                        case "2":
                            comment += matchCard(entry.getValue().get(0).getValue());
                            result = 2;
                            break;
                        default:
                            result = 0;
                            break;
                    }
                }
            }
        switch (result) {
            case 1:
                System.out.println("La main 1 gagne avec " + comment);
                break;
            case 2:
                System.out.println("La main 1 gagne avec " + comment);
                break;
            default:
                System.out.println("Egalite");
                break;
        }
    }

    String matchCard(int num) {
        switch (num) {
            case 11:
                return "V";
            case 12:
                return "D";
            case 13:
                return "R";
            case 14:
                return "As";
            default:
                return String.valueOf(num);
        }
    }
    // 0 equal 1 p1win  2 p2win
    public Map<String, List<Card>> compareHighCard(List<Card> handCards1, List<Card> handCards2) {
        Card card1 = handCards1.get(0);
        Card card2 = handCards2.get(0);
        List<Card> listCard = new ArrayList<Card>();
        Map<String, List<Card>> resMap = new HashMap<>();
        if (card1.getValue() > card2.getValue()) {
            listCard.add(card1);
            resMap.put("1", listCard);
            return resMap;
        } else if (card1.getValue() < card2.getValue()) {
            listCard.add(card2);
            resMap.put("2", listCard);
            return resMap;
        } else {
            resMap.put("0", listCard);
            return resMap;
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
    public int compareFull() {
        if (player1.haveFull() == player2.haveFull()) {
            return 0;
        } else if (player1.haveFull() > player2.haveFull()) {
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
        } else if(player1Pair == null && player2Pair == null) {
            return 0;
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
