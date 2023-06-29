package hexlet.code.games;

import java.util.Random;

public class Progression {

    private static String ruleOfGame = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 9;
    private static final int SECOND_RANGE = 9;
    private static final int RANDOM_POSITION = 9;
    private static final int ARRAY_LENGHT = 10;

    public static String theGame() {
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
        String result = String.valueOf(arr[number]);
        return result;
    }

    public static String ruleOfGame() {

        return ruleOfGame;
    }
}

