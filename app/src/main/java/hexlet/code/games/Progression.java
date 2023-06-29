package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static String result;
    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGHT = 10;

    public static int hideProgressionNumber() {

        int startNum = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int step = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int hidePos = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int[] arr = new int[ARRAY_LENGHT];
        arr[0] = startNum;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + step;
        }
        for (var j = 0; j < arr.length; j++) {
            if (j == hidePos) {
                System.out.print(".. ");
            } else {
                System.out.print(arr[j] + " ");
            }
        }
        System.out.println();
        return arr[hidePos];
    }

    public static String theGame() {
        return String.valueOf(hideProgressionNumber());
    }

    public static void ruleOfGame() {

        System.out.println(RULE_OF_GAME);
    }

    public static void cycleOfGames() {
        boolean isCorrect = true;
        Engine.startGame();
        ruleOfGame();

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
