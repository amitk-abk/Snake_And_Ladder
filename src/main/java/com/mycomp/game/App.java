package com.mycomp.game;

import com.mycomp.game.model.Board;
import com.mycomp.game.model.Player;

import java.util.Scanner;

/**
 * Snake and ladder
 * It has 3 snakes from 7 to 3, 12 to 4 and 18 to 11 and has 3 ladders from 5 to 10, 9 to 14 and 13 to 17
 * The winner is the player who reaches to end at 20th position
 */
public class App {

    // main function to start the game
    public static void main( String[] args ) {
        Board board = Board.getSALBoard();

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter first player name: ");
        String firstPlayerName = reader.nextLine();
        Player first = new Player(board, firstPlayerName);
        System.out.println();

        System.out.println("Enter second player name: ");
        String secondPlayerName = reader.nextLine();
        Player second = new Player(board, secondPlayerName);

        // to play the game, enter names of player one and two, to roll dias respective player should
        // press key of first letter of their respective name.
        // press q to quit the game.
        while (true) {
            System.out.println("\n" + firstPlayerName + ", please roll the dias");
            String fCommand = reader.nextLine();
            if (firstPlayerName.startsWith(fCommand)) {
                int response = first.play();
                if (response == board.getBoardLimit()) {
                    System.out.println(firstPlayerName + " is a winner!!!!!");
                    break;
                }
                else
                    System.out.println(firstPlayerName + " is at " + first.getPlayerPosition());
            }

            System.out.println("\n" + secondPlayerName + ", please roll the dias");
            fCommand = reader.nextLine();
            if (secondPlayerName.startsWith(fCommand)) {
                int response = second.play();
                if (response == board.getBoardLimit()) {
                    System.out.println(secondPlayerName + " is a winner!!!!!");
                    break;
                }
                else
                    System.out.println(secondPlayerName + " is at " + second.getPlayerPosition());
            }

            if (fCommand.equals("q")) {
                System.out.println("Game is quitting with " + firstPlayerName + " being at " + first.getPlayerPosition()
                        + " and " + secondPlayerName + " being at " + second.getPlayerPosition() + ", well played!!");
                break;
            }
        }
    }
}
