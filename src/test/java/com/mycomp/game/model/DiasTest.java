package com.mycomp.game.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiasTest {

    @Test
    public void shouldGenerateRandomValueWithinRange() {
        int value = Dias.playDias();
        boolean rangeCheck = value >= 1 && value <= 6 ? true : false;
        assertTrue(rangeCheck);
    }

    @Test
    public void shouldReturnValueWithinRangeFor50Attempts() {
        for (int n = 0; n < 50; n++) {
            int value = Dias.playDias();
            boolean rangeCheck = value >= 1 && value <= 6 ? true : false;
            assertTrue(rangeCheck);
        }
    }
}
