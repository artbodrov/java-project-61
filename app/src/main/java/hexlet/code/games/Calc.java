package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Calc {

    private static final String RULE_OF_GAME = "What is the result of the expression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static Map<String, Integer> calculateExpression(int num1, int num2) {
        Map<String, Integer> calculateMap = new HashMap<>();
        String result = "";
        int number = 0;

        String[] operators = {"+", "-", "*"};

        int randomOperatorIndex = new java.util.Random().nextInt(operators.length);

        switch (randomOperatorIndex) {
            case 0 -> {
                result = (num1 + " + " + num2);
                number = num1 + num2;
            }
            case 1 -> {
                result = (num1 + " - " + num2);
                number = num1 - num2;
            }
            case 2 -> {
                result = (num1 + " * " + num2);
                number = num1 * num2;
            }
            default -> System.out.println("Oh... really?!!");
        }
        calculateMap.put(result, number);
        return calculateMap;
    }

    private static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < Engine.getTheNumberOfCycles(); i++) {
            int num1 = generateNum();
            int num2 = generateNum();
            Map<String, Integer> calculateMap = calculateExpression(num1, num2);
            for (Map.Entry<String, Integer> pair : calculateMap.entrySet()) {
                map.put(pair.getKey(), String.valueOf(pair.getValue()));
            }
        }
        return map;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME);
        Engine.gameRoundCycle(generateQuestionAnswer());
    }
}
