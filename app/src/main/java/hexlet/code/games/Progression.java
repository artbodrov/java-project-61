package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGTH = 10;

    private static String[] generateProgression(int startNum, int step, int length) {

        String[] arr = new String[length];
        arr[0] = String.valueOf(startNum);
        for (var j = 1; j <= arr.length - 1; j++) {
            int i = Integer.parseInt(arr[j - 1]) + step;
            arr[j] = String.valueOf(i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static String[] generateQuestionAnswer() {
        String[] arr = new String[2];
        int question = 0;
        int answer = 1;
        int hidePos = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        String[] array = generateProgression(
                getRandomInt(FIRST_RANGE, SECOND_RANGE),
                getRandomInt(FIRST_RANGE, SECOND_RANGE),
                ARRAY_LENGTH);
        arr[answer] = String.valueOf(array[hidePos]);
        array[hidePos] = "..";
        arr[question] = Arrays.toString(array)
                .replace("[", "")
                .replace(",", "")
                .replace("]", "");

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
        Engine.run(RULE_OF_GAME, generateListQuestionAnswer());
    }

    public static void main(String[] args) {
        generateQuestionAnswer();
    }
}
