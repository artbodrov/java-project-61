package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String userName;

    public static void startGame() {

        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = Cli.inuptName();
        System.out.println("Hello, " + userName + "!");
        //  playGame(isCorrect);
    }



    public static boolean question(String result) {
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

    public static void endGame(){
        System.out.println("Congratulations, "
                + userName
                + "!");
    }

}
