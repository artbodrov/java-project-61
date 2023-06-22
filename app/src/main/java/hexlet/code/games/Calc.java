package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {

    public static void theGame() {
        boolean isCorrect = true;
        int number = 0;
        Engine.startGame();
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        String[] operators = {"+", "-", "*"};
        for (var i = 0; i < 3; i++) {
            if (isCorrect) {
                int randomOperatorIndex = new java.util.Random().nextInt(operators.length);
                int num1 = random.nextInt(9) + 1;
                int num2 = random.nextInt(9) + 1;

                System.out.print("Question: ");

                switch (randomOperatorIndex) {
                    case 0 -> {
                        System.out.println(num1 + " + " + num2);
                        number = num1 + num2;
                    }
                    case 1 -> {
                        System.out.println(num1 + " - " + num2);
                        number = num1 - num2;
                    }
                    case 2 -> {
                        System.out.println(num1 + " * " + num2);
                        number = num1 * num2;
                    }
                    default -> System.out.println("Oh... really?!!");
                }
                String result = String.valueOf(number);
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
