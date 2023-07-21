package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGTH = 10;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static int[] generateProgression(int startNum, int step, int length) {

        int[] arr = new int[length];
        arr[0] = startNum;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + step;
        }
        return arr;
    }

    private static String[] generateQuestionAnswer() {
        String[] arr = new String[2];
        int question = 0;
        int answer = 1;
        int hidePos = generateNum();
        int[] array = generateProgression(generateNum(), generateNum(), ARRAY_LENGTH);
        StringBuilder builder = new StringBuilder();

        for (var j = 0; j < array.length; j++) {
            if (j == hidePos) {
                builder.append(".. ");
            } else {
                builder.append(array[j] + " ");
            }
        }
        arr[question] = String.valueOf(builder);
        arr[answer] = String.valueOf(array[hidePos]);

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
