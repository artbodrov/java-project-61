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

    private static String[] generateQuestionAnswer(int num1, int num2, char operator) {
        String[] arr = new String[2];
        int question = 0;
        int answer = 1;

        return switch (operator) {
            case '+' -> {
                arr[question] = (num1 + " + " + num2);
                arr[answer] = String.valueOf(num1 + num2);
                yield arr;
            }
            case '-' -> {
                arr[question] = (num1 + " - " + num2);
                arr[answer] = String.valueOf(num1 - num2);
                yield arr;
            }
            case '*' -> {
                arr[question] = (num1 + " * " + num2);
                arr[answer] = String.valueOf(num1 * num2);
                yield arr;
            }
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }

    private static String[][] generateListQuestionAnswer() {
        String[][] arr = new String[Engine.CYCLE][2];

        for (var i = 0; i < arr.length; i++) {
            int num1 = getRandomInt(FIRST_RANGE, SECOND_RANGE);
            int num2 = getRandomInt(FIRST_RANGE, SECOND_RANGE);
            char operator = generateOperator();
            arr[i] = (generateQuestionAnswer(num1, num2, operator));
        }
        return arr;
    }

    public static void gameLaunching() {
        Engine.run(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
