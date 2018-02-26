package com.mycomp.game.model;

import java.util.Random;

public class Dias {

    private static final Random random = new Random();

    public static int playDias() {
        int playValue = 1 + random.nextInt(6);
        return playValue;
    }
}
