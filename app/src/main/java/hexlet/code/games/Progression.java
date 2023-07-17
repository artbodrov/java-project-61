package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Progression {

    private static final String RULE_OF_GAME = "What number is missing in the progression?";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 10;
    private static final int ARRAY_LENGTH = 10;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static int[] generateProgression(int startNum, int step, int length) {

        int[] arr = new int[length];
        arr[0] = startNum;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + step;
        }
        return arr;
    }

    private static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        int hidePos = generateNum();
        int[] arr = generateProgression(generateNum(), generateNum(), ARRAY_LENGTH);
        StringBuilder builder = new StringBuilder();

        for (var j = 0; j < arr.length; j++) {
            if (j == hidePos) {
                builder.append(".. ");
            } else {
                builder.append(arr[j] + " ");
            }
        }
        map.put(String.valueOf(builder), String.valueOf(arr[hidePos]));
        return map;
    }

    public static List<Map<String, String>> generateListQuestionAnswer() {
        List<Map<String, String>> list = new ArrayList<>();
        for (var i = 0; i < Engine.CYCLE; i++) {
            list.add(generateQuestionAnswer());
        }

        return list;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME);
        Engine.gameRoundCycle(generateListQuestionAnswer());
    }
}
