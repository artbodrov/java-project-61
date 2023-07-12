package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static String result;
    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGHT = 10;

    public static int generateNum() {
        int num = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        return num;
    }

    public static int[] generateProgression() {
        int startNum = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int step = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int[] arr = new int[ARRAY_LENGHT];
        arr[0] = startNum;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + step;
        }
        return arr;
    }

    public static Map hideProgressionNumber() {
        Map<String, Integer> map = new HashMap<>();
        int hidePos = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        int[] arr = generateProgression();
        StringBuilder builder = new StringBuilder();

        for (var j = 0; j < arr.length; j++) {
            if (j == hidePos) {
                builder.append(".. ");
            } else {
                builder.append(arr[j] + " ");
            }
        }
        map.put(String.valueOf(builder), arr[hidePos]);
        return map;
    }

    public static Map craeteMap() {
        Map<String, String> map = new HashMap<>();
        for (var i = 0; i < Engine.cycle(); i++) {
            var num1 = generateNum();
            var num2 = generateNum();
            Map<String, Integer> calculateDivisorMap = hideProgressionNumber();
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
