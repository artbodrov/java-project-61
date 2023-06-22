package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {

    private static int number;
    private static String result;
    private static boolean isCorrect;

    public static void theGame() {
        isCorrect = true;
        Engine.startGame();
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        String[] operators = {"+", "-", "*"};
        for (var i = 0; i < 3; i++) {
            if (isCorrect == true) {
                int randomOperatorIndex = new java.util.Random().nextInt(operators.length);
                int num1 = random.nextInt(9) + 1;
                int num2 = random.nextInt(9) + 1;

                System.out.print("Question: ");

                switch (randomOperatorIndex) {

                    case 0:
                        System.out.println(num1 + " + " + num2);
                        number = num1 + num2;
                        break;
                    case 1:
                        System.out.println(num1 + " - " + num2);
                        number = num1 - num2;
                        break;
                    case 2:
                        System.out.println(num1 + " * " + num2);
                        number = num1 * num2;
                        break;
                }
                result = String.valueOf(number);
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