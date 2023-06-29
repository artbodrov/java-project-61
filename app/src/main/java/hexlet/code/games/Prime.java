package hexlet.code.games;

import java.util.Random;

public class Prime {

    private static String ruleOfGame = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_RANGE = 99;

    private static boolean isPrime() {
        Random random = new Random();
        int number = random.nextInt(FIRST_RANGE) + 2;
        System.out.println(number);
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String theGame() {
        boolean flag = true;
        String result;
        if (flag == isPrime()) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }
//
    public static String ruleOfGame() {

        return ruleOfGame;
    }
}

