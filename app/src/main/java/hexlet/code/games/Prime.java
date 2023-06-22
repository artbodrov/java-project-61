package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {

    public static void theGame() {
        boolean isCorrect = true;
        Engine.startGame();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Random random = new Random();
        for (var i = 0; i < 3; i++) {
            if (isCorrect) {
                int number = random.nextInt(99) + 2;
                String result;
                if (number % 2 == 0) {
                    result = "no";
                } else {
                    for (int j = 3; j * j <= number; j += 2) {
                        if (number % j == 0) {
                            result = "no";
                        }
                    }
                    result = "yes";
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

