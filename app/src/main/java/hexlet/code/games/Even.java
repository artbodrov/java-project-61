package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {

    public static void theGame() {
        boolean isCorrect = true;
        Engine.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        for (var i = 0; i < 3; i++) {
            if (isCorrect) {
                int number = random.nextInt(99) + 1;
                String result;
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
