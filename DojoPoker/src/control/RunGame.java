package control;

import java.util.Scanner;

public class RunGame {

    public void startGame() {
        //Get input names
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input names of players,split with ,");
        String str = scanner.nextLine();

        String names[] = str.trim().split(",");
        Game game = new Game(names);
        game.showAllPlayers();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //end the game
        game.endGame();


    }


}
