package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Gcd {

    private static final String RULE_OF_GAME = "Find the greatest common divisor of given numbers.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static int calculateDivisor(int num1, int num2) {

        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        return num1 + num2;
    }

    private static String[] generateQuestionAnswer() {
        String[] arr = new String[2];
        int num1 = generateNum();
        int num2 = generateNum();
        int question = 0;
        int answer = 1;
        String result = num1 + " " + num2;
        arr[question] = result;
        arr[answer] = String.valueOf(calculateDivisor(num1, num2));

        return arr;
    }

    private static String[][] generateListQuestionAnswer() {
        String[][] arr = new String[Engine.CYCLE][2];

        for (var i = 0; i < arr.length; i++) {
            arr[i] = generateQuestionAnswer();
        }
        return arr;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
