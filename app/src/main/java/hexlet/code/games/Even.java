package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {

    private static String result;
    private static final String RULE_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 99;

    private static boolean isEven() {
        Random random = new Random();

        int number = random.nextInt(FIRST_RANGE) + 1;
        System.out.println(number);

        return number % 2 == 0;
    }

    public static String theGame() {

        boolean flag = true;
        if (flag == isEven()) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }

    public static void ruleOfGame() {

        System.out.println(RULE_OF_GAME);
    }

    public static void cycleOfGames() {
        boolean isCorrect = true;
        Engine.startGame();
        ruleOfGame();

        for (var i = 0; i < Engine.cycle(); i++) {
            System.out.print("Question: ");
            result = theGame();
            if (isCorrect) {
                isCorrect = Engine.question(result);
            } else {
                break;
            }
            if (i == Engine.cycle() - 1 && isCorrect) {
                Engine.endGame();
            }
        }
    }
}
