package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Engine {
    private static String userName;
    public static final int CYCLE = 3;

    public static void helloGame(String ruleOfGame) {

        System.out.print("May I have your name? ");
        userName = Cli.inuptName();
        System.out.println("Hello, " + userName + "!");
        System.out.println(ruleOfGame);
    }

    private static boolean getQuestionAnswer(String str) {
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

    public static void gameRoundCycle(List<Map<String, String>> list) {
        boolean isCorrect = true;
        for (Map<String, String> map : list) {
            if (isCorrect) {
                for (Map.Entry<String, String> pair : map.entrySet()) {
                    System.out.print("Question: ");
                    System.out.println(pair.getKey());
                    isCorrect = getQuestionAnswer(pair.getValue());
                }
            } else {
                break;
            }

            if (isCorrect) {
                Engine.endGame();
            }
        }
    }
}
