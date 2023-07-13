package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static hexlet.code.Engine.helloGame;

public class App {

    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final String RULE_OF_GAME = "Rule of game";

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
            int choice = scanner.nextInt();

            switch (choice) {
                case EVEN -> {
                    Even.gameLaunching();
                }
                case CALC -> {
                    Calc.gameLaunching();
                }
                case GCD -> {
                    Gcd.gameLaunching();
                }
                case PROGRESSION -> {
                    Progression.gameLaunching();
                }
                case PRIME -> {
                    Prime.gameLaunching();
                }
                case GREET -> helloGame(RULE_OF_GAME);
                default -> {
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
