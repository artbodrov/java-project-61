package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Prime {

    private static final String RULE_OF_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static int generateNum() {
        return getRandomInt(FIRST_RANGE, SECOND_RANGE);
    }

    private static String isPrime(int number) {

        if (number <= 1) {
            return "no";
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    private static Map<String, String> generateQuestionAnswer() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < Engine.getTheNumberOfCycles(); i++) {
            int number = generateNum();
            map.put(String.valueOf(number), isPrime(number));
        }
        return map;
    }

    public static void gameLaunching() {
        Engine.helloGame(RULE_OF_GAME);
        Engine.gameRoundCycle(generateQuestionAnswer());
    }
}
