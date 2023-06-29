package hexlet.code.games;

import java.util.Random;

public class Even {

    private static String ruleOfGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 99;

    public static boolean isEven() {
        Random random = new Random();

        int number = random.nextInt(FIRST_RANGE) + 1;
        System.out.println(number);
        if (number % 2 == 0) {
            return  true;
        } else {
            return  false;
        }
    }

    public static String theGame() {
        boolean flag = true;
        String result;
        if (flag == isEven()) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }

    public static String ruleOfGame() {

        return ruleOfGame;
    }
}
