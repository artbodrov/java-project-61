package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    private static String result;
    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 9;
    private static final int SECOND_RANGE = 9;
    private static final int RANDOM_POSITION = 9;
    private static final int ARRAY_LENGHT = 10;

    public static int hideProgressionNumber() {
        Random random = new Random();

        int num1 = random.nextInt(FIRST_RANGE) + 1;
        int num2 = random.nextInt(SECOND_RANGE) + 1;
        int number = random.nextInt(RANDOM_POSITION) + 1;
        int[] arr = new int[ARRAY_LENGHT];
        arr[0] = num1;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + num2;
        }
        for (var j = 0; j < arr.length; j++) {
            if (j == number) {
                System.out.print(".. ");
            } else {
                System.out.print(arr[j] + " ");
            }
        }
        System.out.println();
        return arr[number];
    }

    public static String theGame() {
        return String.valueOf(hideProgressionNumber());
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
