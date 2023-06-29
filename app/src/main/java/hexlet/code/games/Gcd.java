package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Gcd {

    private static String result;
    private static final String RULE_OF_GAME = "Find the greatest common divisor of given numbers.";
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

    public static String theGame() {
        String result = String.valueOf(calculateDivisor());
        return result;
    }

    public static void ruleOfGame() {

        System.out.println(RULE_OF_GAME);
    }

    public static void cycleOfGames() {
        boolean isCorrect = true;

        for (var i = 0; i < Engine.cycle(); i++) {
            System.out.print("Question: ");
            result = theGame();
            if (isCorrect) {
                isCorrect = Engine.question(result);
            } else {
                break;
            }
            if (i == Engine.cycle() - 1 && isCorrect) {
                Engine.endGame();
            }
        }
    }
}
