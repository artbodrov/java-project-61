package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Even {

    private static final String RULE_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    private static String[] generateQuestionAnswer() {
        String[] arr = new String[2];
        int number = generateNum();
        int question = 0;
        int answer = 1;
        if (isEven(number)) {
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
        Engine.helloGame(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
