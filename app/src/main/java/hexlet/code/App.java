package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.cycleOfGames;
import static hexlet.code.Engine.startGame;

public class App {

    public static int choice;

    public static void main(String[] args) {

        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        try {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 2 -> {
                    cycleOfGames(2);
                }
                case 3 -> {
                    cycleOfGames(3);
                }
                case 4 -> {
                    cycleOfGames(4);
                }
                case 5 -> {
                    cycleOfGames(5);
                }
                case 6 -> {
                    cycleOfGames(6);
                }
                default -> {
                    break;
                }


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
