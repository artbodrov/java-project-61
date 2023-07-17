package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                result = "+";

            }
            case 1 -> {
                result = "-";

            }
            case 2 -> {
                result = "*";

            }
            default -> System.out.println("Oh... really?!!");
        }
        return result;
    }

    private static Map<String, String> generateQuestionAnswer(int num1, int num2) {
        Map<String, String> calculateMap = new HashMap<>();
        String result = "";
        int number = 0;
        String expression = generateExpression();

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

        calculateMap.put(result, String.valueOf(number));
        return calculateMap;
    }

    private static List<Map<String, String>> generateListQuestionAnswer() {
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < Engine.CYCLE; i++) {
            int num1 = generateNum();
            int num2 = generateNum();
            list.add(generateQuestionAnswer(num1, num2));
        }
        return list;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME);
        Engine.gameRoundCycle(generateListQuestionAnswer());
    }
}
