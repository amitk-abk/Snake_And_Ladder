package com.mycomp.game.model;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class BoardTest {

    private Board board = Board.getSALBoard();

    @Test
    public void shouldReturnLowerPositionForSnake() {
        int newPosition = board.getNewPositionForPlayer(7);
        assertEquals(3, newPosition);
    }

    @Test
    public void shouldReturnHigherPositionWhenEncounteredLadder() {
        int newPosition = board.getNewPositionForPlayer(5);
        assertEquals(10, newPosition);
    }

    @Test
    public void shouldReturnSameIfNoSnakeOrLadderEncountered() {
        int newPosition = board.getNewPositionForPlayer(0);
        assertEquals(0, newPosition);

        newPosition = board.getNewPositionForPlayer(2);
        assertEquals(2, newPosition);
    }

    @Test
    public void shouldReturnBoardLengthWhenReachedAtEnd() {
        int newPosition = board.getNewPositionForPlayer(board.getBoardLimit());
        assertEquals(board.getBoardLimit(), newPosition);
    }

    @Test
    public void shouldReturnErrorWhenInputPositionGreaterThanLimit() {
        int newPosition = board.getNewPositionForPlayer(21);
        assertEquals(-1, newPosition);
    }
}
