package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    public static void theGame() {
        boolean isCorrect = true;
        Engine.startGame();
        System.out.println("Please enter the game number and press Enter.");
        Random random = new Random();
        for (var i = 0; i < 3; i++) {
            if (isCorrect) {
                String result;
                int num1 = random.nextInt(9) + 1;
                int num2 = random.nextInt(9) + 1;
                int number = random.nextInt(9) + 1;
                System.out.print("Question: ");
                int[] arr = new int[10];
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
                result = String.valueOf(arr[number]);
                //    System.out.println(number);
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
