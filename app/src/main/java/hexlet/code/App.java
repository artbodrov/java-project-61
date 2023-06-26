package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.cycleOfGames;

public class App {

    public static int choice;

    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        switch (choice) {
            case 2, 3, 4, 5, 6 -> cycleOfGames(choice);

            default -> System.out.println("bye");
        }
    }
}
