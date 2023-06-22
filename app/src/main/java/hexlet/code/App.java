package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static int choice;

    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            if (choice == 2) {
                Even.theGame();
            }
            if (choice == 3) {
                Calc.theGame();
            }
        } catch (InputMismatchException e) {

        }
    }
}