package hexlet.code.games;

import java.util.Random;

public class Gcd {

    private static String ruleOfGame = "Find the greatest common divisor of given numbers.";
    private static final int FIRST_RANGE = 99;
    private static final int SECOND_RANGE = 99;

    private static int calculateDivisor() {

        Random random = new Random();
        int num1 = random.nextInt(FIRST_RANGE) + 1;
        int num2 = random.nextInt(SECOND_RANGE) + 1;
        System.out.println(num1 + " " + num2);
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        int result = num1 + num2;

        return result;
    }
//
    public static String theGame() {
        String result = String.valueOf(calculateDivisor());
        return result;
    }

    public static String ruleOfGame() {

        return ruleOfGame;
    }
}
