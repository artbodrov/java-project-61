package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {

    private static String result;
    private static final String RULE_OF_GAME = "What is the result of the expression?";
    private static final int FIRST_RANGE = 9;
    private static final int SECOND_RANGE = 9;

    private static int calculate() {

        int number = 0;

        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        int randomOperatorIndex = new java.util.Random().nextInt(operators.length);
        int num1 = random.nextInt(FIRST_RANGE) + 1;
        int num2 = random.nextInt(SECOND_RANGE) + 1;

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
        return number;
    }

    public static String theGame() {
        return String.valueOf(calculate());
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
