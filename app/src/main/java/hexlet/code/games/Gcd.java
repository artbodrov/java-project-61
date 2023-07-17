package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Gcd {

    private static final String RULE_OF_GAME = "Find the greatest common divisor of given numbers.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static int calculateDivisor(int num1, int num2) {

        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        return num1 + num2;
    }

    private static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        int num1 = generateNum();
        int num2 = generateNum();
        String result = num1 + " " + num2;
      //  calculateDivisor(num1, num2);
        map.put(result, String.valueOf(calculateDivisor(num1, num2)));

        return map;
    }

    private static List<Map<String, String>> generateListQuestionAnswer() {
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < Engine.CYCLE; i++) {
            list.add(generateQuestionAnswer());
        }
        return list;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME);
        Engine.gameRoundCycle(generateListQuestionAnswer());
    }
}
