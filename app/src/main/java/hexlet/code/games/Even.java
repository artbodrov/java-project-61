package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {

    private static int number;
    private static String result;
    private static boolean isCorrect;

    public static void theGame() {
        isCorrect = true;
        Engine.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        for (var i = 0; i < 3; i++) {
            if (isCorrect == true) {
                number = random.nextInt(99) + 1;
                if (number % 2 == 0) {
                    result = "yes";
                } else {
                    result = "no";
                }
                System.out.println(number);
                isCorrect = Engine.question(result);
            } else {
                break;
            }
            if (i == 2) {
                Engine.endGame();
            }
        }
    }
}