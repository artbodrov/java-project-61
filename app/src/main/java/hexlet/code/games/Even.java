package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.utils.Randomizer.getRandomInt;

public class Even {

    private static String result;
    private static final String RULE_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int FIRST_RANGE = 1;
    private static final int SECOND_RANGE = 100;

    private static boolean isEven() {

        int number = getRandomInt(FIRST_RANGE, SECOND_RANGE);
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
