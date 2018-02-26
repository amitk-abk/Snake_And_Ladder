package com.mycomp.game.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Player.class)
public class PlayerTest {

    private String name = "fone";
    private Board board = Board.getSALBoard();


    @Test
    public void shouldAbleToIncrementPosition() {
        Player one = new Player(board, name);
        int newPosition = one.play();
        assertEquals(newPosition, one.getPlayerPosition());
    }


    @Test
    public void shouldStepBackWhenSnakeIsEncountered() throws Exception {
        Player one = PowerMockito.spy(new Player(board, name));
        PowerMockito.doReturn(7).when(one, "rollDias");
        int newPosition = one.play();
        assertEquals(3, newPosition);
    }

    @Test
    public void shouldStepForwardWhenLadderIsEncountered() throws Exception {
        Player one = PowerMockito.spy(new Player(board, name));
        PowerMockito.doReturn(5).when(one, "rollDias");
        int newPosition = one.play();
        assertEquals(10, newPosition);
    }

    @Test
    public void shouldDeclareAsWinnerWhenReachedAtLastPosition() throws Exception {
        Player one = PowerMockito.spy(new Player(board, name));
        PowerMockito.doReturn(20).when(one, "rollDias");
        int newPosition = one.play();
        assertEquals(board.getBoardLimit(), newPosition);
    }
}
