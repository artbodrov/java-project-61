package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Prime {

    private static final String RULE_OF_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static boolean isPrime(int number) {

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

    private static String[] generateQuestionAnswer() {
        String[] arr = new String[2];
        int number = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int question = 0;
        int answer = 1;

        if (isPrime(number)) {
            arr[question] = String.valueOf(number);
            arr[answer] = "yes";
        } else {
            arr[question] = String.valueOf(number);
            arr[answer] = "no";
        }
        return arr;
    }

    public static String[][] generateListQuestionAnswer() {
        String[][] arr = new String[Engine.CYCLE][2];

        for (var i = 0; i < arr.length; i++) {
            arr[i] = generateQuestionAnswer();
        }
        return arr;
    }

    public static void gameLaunching() {
        Engine.run(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
