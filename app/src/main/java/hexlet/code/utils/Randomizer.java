package hexlet.code.utils;

import java.util.Random;

public class Randomizer {

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
