package hexlet.code.games;

import java.util.Random;

public class Even {

    private static String ruleOfGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 99;

    public static String theGame() {
        String result;
        Random random = new Random();

        int number = random.nextInt(FIRST_RANGE) + 1;

        if (number % 2 == 0) {
            result = "yes";
        } else {
            result = "no";
        }
        System.out.println(number);
        return result;
    }

    public static String ruleOfGame() {

        return ruleOfGame;
    }
}
