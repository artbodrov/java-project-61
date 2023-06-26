package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    private static String progression = "What number is missing in the progression?";
    private static String prime = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static String gcd = "Find the greatest common divisor of given numbers.";
    private static String calc = "What is the result of the expression?";
    private static String even = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String userName;
    private static String result;

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

        for (var i = 0; i < 3; i++) {

            if (isCorrect) {
                if (game == 2) {
                    System.out.print("Question: ");
                    result = Even.theGame();
                }
                if (game == 3) {
                    System.out.print("Question: ");
                    result = Calc.theGame();
                }
                if (game == 4) {
                    System.out.print("Question: ");
                    result = GCD.theGame();
                }
                if (game == 5) {
                    System.out.print("Question: ");
                    result = Progression.theGame();
                }
                if (game == 6) {
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
        if (q == 2) {
            mainRule = even;
        }
        if (q == 3) {
            mainRule = calc;
        }
        if (q == 4) {
            mainRule = gcd;
        }
        if (q == 5) {
            mainRule = progression;
        }
        if (q == 6) {
            mainRule = prime;
        }
        System.out.println(mainRule);
    }
}
