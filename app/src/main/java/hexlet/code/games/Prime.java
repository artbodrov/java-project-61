package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Prime {

    private static final String RULE_OF_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        int number = generateNum();
        if (isPrime(number)) {
            map.put(String.valueOf(number), "yes");
        } else {
            map.put(String.valueOf(number), "no");
        }
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
