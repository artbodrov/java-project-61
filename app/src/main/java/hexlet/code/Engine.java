package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int CYCLE = 3;

    public static void ifNoGame(String ruleOfGame) {

        System.out.print("May I have your name? ");
        String name = Cli.inuptName();
        System.out.println("Hello, " + name + "!");
        System.out.println(ruleOfGame);
    }

    public static void runOld(String ruleOfGame, String[][] arr) {

        System.out.print("May I have your name? ");
        String name = Cli.inuptName();
        System.out.println("Hello, " + name + "!");
        System.out.println(ruleOfGame);
        gameRoundCycle(arr, name);
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
                    + yourAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'"
                    + answer + "'" + ". Let's try again, "
                    + name + "!");
            return false;
        }
    }

    public static void gameRoundCycle(String[][] arr, String name) {
        boolean isCorrect = true;
        int question = 0;
        int answer = 1;

        for (String[] strings : arr) {
            if (isCorrect) {
                System.out.print("Question: ");
                System.out.println(strings[question]);
                isCorrect = compareAnswers(strings[answer], name);

            } else {
                break;
            }
        }
        if (isCorrect) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void run(String ruleOfGame, String[][] arr) {

        boolean isCorrect = true;
        int question = 0;
        int answer = 1;
        String yourAnswer;

        System.out.print("May I have your name? ");
        String name = Cli.inuptName();
        System.out.println("Hello, " + name + "!");
        System.out.println(ruleOfGame);

        for (String[] strings : arr) {
            if (isCorrect) {
                System.out.print("Question: ");
                System.out.println(strings[question]);
                Scanner scanner = new Scanner(System.in);
                yourAnswer = scanner.nextLine();
                System.out.println("Your answer: " + yourAnswer);
                if (yourAnswer.equals(String.valueOf(strings[answer]))) {
                    System.out.println("Correct!");
                } else {
                    isCorrect = false;
                    System.out.println("'"
                            + yourAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'"
                            + answer + "'" + ". Let's try again, "
                            + name + "!");
                }
            } else {
                break;
            }
        }
        if (isCorrect) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
