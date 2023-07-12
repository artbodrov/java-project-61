package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    private static String userName;
    private static final int CYCLE = 3;

    public static void startGame(String ruleOfGame) {

        System.out.print("May I have your name? ");
        userName = Cli.inuptName();
        System.out.println("Hello, " + userName + "!");
        System.out.println(ruleOfGame);
    }

    private static boolean question(String str) {
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

    private static void endGame() {
        System.out.println("Congratulations, "
                + userName
                + "!");
    }

    public static int cycle() {
        return CYCLE;
    }

    public static void mapa(Map map) {
        boolean isCorrect = true;
        Map<String, String> temp = map;

        for (Map.Entry<String, String> pair : temp.entrySet()) {
            if (isCorrect) {
                System.out.print("Question: ");
                System.out.println(pair.getKey());
                isCorrect = question(pair.getValue());
            } else {
                break;
            }
        }
        if (isCorrect) {
            Engine.endGame();
        }
    }
}
