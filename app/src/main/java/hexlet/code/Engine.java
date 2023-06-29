package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
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

        if (answer.equals(String.valueOf(str))) {
            System.out.println("Correct!");
        } else {
            flag = false;
            System.out.println("'"
                    + answer
                    + "'"
                    + " is wrong answer ;(. Correct answer was "
                    + "'"
                    + str
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

    public static int cycle() {
        return CYCLE;
    }
}
