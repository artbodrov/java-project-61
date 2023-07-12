package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Even {

    private static String result;
    private static final String RULE_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    public static int generateNum() {
        int num = getRandomInt(FIRST_RANGE, SECOND_RANGE);
        return num;
    }

    private static String isEven(int number) {

        if (number % 2 == 0) {
            return "yes";
        } else return "no";
    }

    public static Map craeteMap() {
        Map<String, String> map = new HashMap<>();
        for (var i = 0; i < Engine.cycle(); i++) {
            var number = generateNum();
            map.put(String.valueOf(number), isEven(number));
        }
        return map;
    }

    public static void cycleOfGames() {
        Engine.startGame(RULE_OF_GAME);
        Engine.mapa(craeteMap());
    }
}
