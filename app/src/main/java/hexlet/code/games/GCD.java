package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {

    public static void theGame() {
        boolean isCorrect = true;
        Engine.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");
        Random random = new Random();
        for (var i = 0; i < 3; i++) {
            if (isCorrect) {
                int num1 = random.nextInt(99) + 1;
                int num2 = random.nextInt(99) + 1;
                System.out.print("Question: ");
                System.out.println(num1 + " " + num2);
                while (num1 != 0 && num2 != 0) {
                    if (num1 > num2) {
                        num1 = num1 % num2;
                    } else {
                        num2 = num2 % num1;
                    }
                }
                String result = String.valueOf(num1 + num2);
                //   System.out.println(num1 + " " + num2);
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
