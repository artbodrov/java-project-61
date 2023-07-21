package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Calc {

    private static final String RULE_OF_GAME = "What is the result of the expression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static String generateExpression() {
        String result = "";
        String[] operators = {"+", "-", "*"};

        int randomOperatorIndex = new java.util.Random().nextInt(operators.length);

        switch (randomOperatorIndex) {
            case 0 -> {
                result = operators[0];
            }
            case 1 -> {
                result = operators[1];
            }
            case 2 -> {
                result = operators[2];
            }
            default -> System.out.println("Oh... really?!!");
        }
        return result;
    }

    private static String[] generateQuestionAnswer(int num1, int num2, String expression) {
        String[] arr = new String[2];
        String result = "";
        int number = 0;
        int question = 0;
        int answer = 1;

        if (expression.equals("+")) {
            result = (num1 + " + " + num2);
            number = num1 + num2;
        } else if (expression.equals("-")) {
            result = (num1 + " - " + num2);
            number = num1 - num2;
        } else if (expression.equals("*")) {
            result = (num1 + " * " + num2);
            number = num1 * num2;
        }
        arr[question] = result;
        arr[answer] = String.valueOf(number);

        return arr;
    }

    private static String[][] generateListQuestionAnswer() {
        String[][] arr = new String[Engine.CYCLE][2];

        for (var i = 0; i < arr.length; i++) {
            int num1 = generateNum();
            int num2 = generateNum();
            String expression = generateExpression();
            arr[i] = (generateQuestionAnswer(num1, num2, expression));
        }
        return arr;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME, generateListQuestionAnswer());
    }
}
