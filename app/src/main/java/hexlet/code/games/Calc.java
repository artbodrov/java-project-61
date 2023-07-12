package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Calc {

    private static final String RULE_OF_GAME = "What is the result of the expression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;

    public static int generateNum() {
        int num = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        return num;
    }

    private static Map calculate(int num1, int num2) {
        Map<String, Integer> calculateMap = new HashMap<>();
        var result = "";
        var number = 0;

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

    public static Map craeteMap() {
        Map<String, String> map = new HashMap<>();
        for (var i = 0; i < Engine.cycle(); i++) {
            var num1 = generateNum();
            var num2 = generateNum();
            Map<String, Integer> calculateMap = calculate(num1, num2);
            for (Map.Entry<String, Integer> pair : calculateMap.entrySet()) {
                map.put(pair.getKey(), String.valueOf(pair.getValue()));
            }
        }
        return map;
    }

    public static void cycleOfGames() {
        Engine.startGame(RULE_OF_GAME);
        Engine.mapa(craeteMap());
    }
}

