package com.mycomp.game.model;

public class Player {

    private int playerPosition;
    private Board board;
    private String name;

    public Player(Board board, String name) {
        this.board = board;
        playerPosition = 0;
        this.name = name;
    }

    public int play() {
        int diasCount = rollDias();
        System.out.println(".......Dias rolled to " + diasCount);
        int newPosition = playerPosition + diasCount;
        newPosition = board.getNewPositionForPlayer(newPosition);
        if (newPosition != -1)
            playerPosition = newPosition;
        return playerPosition;
    }

    private int rollDias() {
        return Dias.playDias();
    }

    public int getPlayerPosition() {
        return playerPosition;
    }
}
