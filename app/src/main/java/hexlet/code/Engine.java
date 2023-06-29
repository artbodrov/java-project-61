package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static String userName;
    private static String result;
    private static final int CYCLE = 3;

    public static void startGame() {

        System.out.print("May I have your name? ");
        userName = Cli.inuptName();
        System.out.println("Hello, " + userName + "!");
    }

    public static boolean question(String str) {
        boolean flag = true;
        String answer;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        System.out.println("Your answer: " + answer);

        if (answer.equals(String.valueOf(result))) {
            System.out.println("Correct!");
        } else {
            flag = false;
            System.out.println("'"
                    + answer
                    + "'"
                    + " is wrong answer ;(. Correct answer was "
                    + "'"
                    + result
                    + "'"
                    + ". Let's try again, "
                    + userName
                    + "!");
        }
        return flag;
    }

    public static void endGame() {
        System.out.println("Congratulations, "
                + userName
                + "!");
    }

    public static void cycleOfGames(int game) {
        boolean isCorrect = true;

        startGame();
        rules(game);

        for (var i = 0; i < CYCLE; i++) {

            if (isCorrect) {
                if (game == EVEN) {
                    System.out.print("Question: ");
                    result = Even.theGame();
                }
                if (game == CALC) {
                    System.out.print("Question: ");
                    result = Calc.theGame();
                }
                if (game == GCD) {
                    System.out.print("Question: ");
                    result = Gcd.theGame();
                }
                if (game == PROGRESSION) {
                    System.out.print("Question: ");
                    result = Progression.theGame();
                }
                if (game == PRIME) {
                    System.out.print("Question: ");
                    result = Prime.theGame();
                }
                isCorrect = question(result);
            } else {
                break;
            }
            if (i == 2 && isCorrect) {
                endGame();
            }
        }
    }

    public static void rules(int q) {
        String mainRule = "WTF";
        if (q == EVEN) {
            mainRule = Even.ruleOfGame();
        }
        if (q == CALC) {
            mainRule = Calc.ruleOfGame();
        }
        if (q == GCD) {
            mainRule = Gcd.ruleOfGame();
        }
        if (q == PROGRESSION) {
            mainRule = Progression.ruleOfGame();
        }
        if (q == PRIME) {
            mainRule = Prime.ruleOfGame();
        }
        System.out.println(mainRule);
    }
}
