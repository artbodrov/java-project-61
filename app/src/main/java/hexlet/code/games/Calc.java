package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Calc {

    private static final String RULE_OF_GAME = "What is the result of the expression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;

    private static char generateOperator() {
        char[] operators = {'+', '-', '*'};
        var indexOperator = Randomizer.getRandomInt(0, operators.length - 1);

        return operators[indexOperator];
    }

    private static int generateAnswer(int num1, int num2, char operator) {

        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }

    private static String generateQuestion(int num1, int num2, char operator) {

        return switch (operator) {
            case '+' -> num1 + " + " + num2;

            case '-' -> num1 + " - " + num2;

            case '*' -> num1 + " * " + num2;
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }

    private static String[][] generateListQuestionAnswer() {
        String[][] arr = new String[Engine.CYCLE][2];
        int question = 0;
        int answer = 1;
        for (var i = 0; i < arr.length; i++) {
            int num1 = getRandomInt(FIRST_RANGE, SECOND_RANGE);
            int num2 = getRandomInt(FIRST_RANGE, SECOND_RANGE);
            char operator = generateOperator();
            String[] array = new String[2];
            array[question] = (generateQuestion(num1, num2, operator));
            array[answer] = String.valueOf((generateAnswer(num1, num2, operator)));
            arr[i] = array;
        }
        return arr;
    }

    public static void gameLaunching() {
        Engine.run(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
