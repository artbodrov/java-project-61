package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGHT = 10;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static int[] generateProgression() {
        int startNum = generateNum();
        int step = generateNum();
        int[] arr = new int[ARRAY_LENGHT];
        arr[0] = startNum;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + step;
        }
        return arr;
    }

    private static Map<String, Integer> hideProgressionNumber() {
        Map<String, Integer> map = new HashMap<>();
        int hidePos = generateNum();
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

    public static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        for (var i = 0; i < Engine.getTheNumberOfCycles(); i++) {
            Map<String, Integer> calculateDivisorMap = hideProgressionNumber();
            for (Map.Entry<String, Integer> pair : calculateDivisorMap.entrySet()) {
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
