package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Gcd {

    private static final String RULE_OF_GAME = "Find the greatest common divisor of given numbers.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        int num = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        return num;
    }

    private static Map<String, Integer> calculateDivisor(int num1, int num2) {
        Map<String, Integer> calculateDivisorMap = new HashMap<>();
        var result = num1 + " " + num2;

        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        var number = num1 + num2;
        calculateDivisorMap.put(result, number);
        return calculateDivisorMap;
    }

    private static Map<String, String> craeteMap() {
        Map<String, String> map = new HashMap<>();
        for (var i = 0; i < Engine.cycle(); i++) {
            var num1 = generateNum();
            var num2 = generateNum();
            Map<String, Integer> calculateDivisorMap = calculateDivisor(num1, num2);
            for (Map.Entry<String, Integer> pair : calculateDivisorMap.entrySet()) {
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
