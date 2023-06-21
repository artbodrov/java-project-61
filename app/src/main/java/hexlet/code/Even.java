package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static int number;
    private static String yes = "yes";
    private static String no = "no";
    private static String answer;
    private static String userName;

    private static boolean randomNumber() {

        boolean flag = true;
        Random random = new Random();
        number = random.nextInt(99) + 1;
        System.out.println(number);
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();

        if (number % 2 == 0) {
            if (answer.equals(yes)) {
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                System.out.println("Your answer: " + answer);
                System.out.println(answer
                        + " is wrong answer ;(. Correct answer was 'no'. Let's try again, "
                        + userName
                        + "!");
                flag = false;
            }
        } else {
            if (answer.equals(no)) {
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                System.out.println("Your answer: " + answer);
                System.out.println(answer
                        + " is wrong answer ;(. Correct answer was 'yes'. Let's try again, "
                        + userName
                        + "!");
                flag = false;
            }
        }
        return flag;
    }

    public static void startEvenGame() {

        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = Cli.inuptName();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        playGame();
    }

    private static void playGame() {

        for (var i = 0; i < 3; i++) {
            if (randomNumber() == true) {
            } else {
                break;
            }
        }
        System.out.println("Congratulations, "
                + userName
                + "!");
    }
}

