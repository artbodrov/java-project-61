package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int CYCLE = 3;

    public static void ifNoGame(String ruleOfGame) {

        System.out.print("May I have your name? ");
        String name = Cli.inuptName();
        helloName(name);
        System.out.println(ruleOfGame);
    }

    public static void helloGame(String ruleOfGame, String[][] arr) {

        System.out.print("May I have your name? ");
        String name = Cli.inuptName();
        helloName(name);
        System.out.println(ruleOfGame);
        gameRoundCycle(arr, name);
    }

    public static void helloName(String str) {
        System.out.println("Hello, " + str + "!");
    }

    private static boolean compareAnswers(String answer, String name) {
        String yourAnswer;
        Scanner scanner = new Scanner(System.in);
        yourAnswer = scanner.nextLine();
        System.out.println("Your answer: " + yourAnswer);

        if (yourAnswer.equals(String.valueOf(answer))) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'"
                    + yourAnswer
                    + "'"
                    + " is wrong answer ;(. Correct answer was "
                    + "'"
                    + answer
                    + "'"
                    + ". Let's try again, "
                    + name
                    + "!");
            return false;
        }
    }

    private static void endGame(String name) {
        System.out.println("Congratulations, "
                + name
                + "!");
    }

    public static void gameRoundCycle(String[][] arr, String name) {
        boolean isCorrect = true;
        int question = 0;
        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            if (isCorrect) {
                System.out.print("Question: ");
                System.out.println(arr[i][question]);
                isCorrect = compareAnswers(arr[i][answer], name);

            } else {
                break;
            }
        }
        if (isCorrect) {
            endGame(name);
        }
    }
}
