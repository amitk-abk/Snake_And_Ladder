package com.mycomp.game;


import com.mycomp.game.model.Board;
import com.mycomp.game.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void gameShouldMoveWithFirstMove() {
        Board board = Board.getSALBoard();
        Player first = new Player(board, "FirstOne");
        first.play();
        assertTrue(first.getPlayerPosition() > 0);
    }

}
