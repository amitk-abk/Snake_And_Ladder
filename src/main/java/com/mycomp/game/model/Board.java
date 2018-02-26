package com.mycomp.game.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final int[] board = new int[20];

    private static final Map<Integer, Integer> snakes = new HashMap<>();
    private static final Map<Integer, Integer> ladders = new HashMap<>();

    private static final Board INSTANCE = new Board();

    // initialize snakes and ladders at board creation
    private Board() {
        snakes.put(7, 3);
        snakes.put(12, 4);
        snakes.put(18, 11);

        ladders.put(5, 10);
        ladders.put(9, 14);
        ladders.put(13, 17);
    }

    public static Board getSALBoard() {
        return INSTANCE;
    }

    private boolean isSnakePosition(int position) {
        return snakes.containsKey(position);
    }

    private int getNewPositionForSnake(int position) {
        return snakes.get(position);
    }

    private boolean isLadderPosition(int currentPosition) {
        return ladders.containsKey(currentPosition);
    }

    private int getNewPositionForLadder(int currentPosition) {
        return ladders.get(currentPosition);
    }

    public int getBoardLimit() {
        return board.length;
    }

    private int checkForSnakeOrLadderAndGetNewPosition(int newPosition) {
        int currPosition = newPosition;
        if (isSnakePosition(newPosition)) {
            currPosition = getNewPositionForSnake(newPosition);
            System.out.println("---------Encountered snake!!! moving back from " + newPosition + " to " + currPosition);
        } else if (isLadderPosition(newPosition)) {
            currPosition = getNewPositionForLadder(newPosition);
            System.out.println("+++++++++Encountered ladder!!! moving ahead from " + newPosition + " to " + currPosition);
        }
        return currPosition;
    }

    public int getNewPositionForPlayer(int newPosition) {
        if (newPosition < getBoardLimit()) {
            System.out.println(".......Moved to position " + newPosition);
            return checkForSnakeOrLadderAndGetNewPosition(newPosition);
        } else if (newPosition == getBoardLimit()) {
            System.out.println(".......Moved to position " + newPosition);
            return newPosition;
        }
        return -1;
    }
}
