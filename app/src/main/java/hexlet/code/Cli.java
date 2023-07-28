package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String inuptName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void ifNoGame(String ruleOfGame) {

        System.out.print("May I have your name? ");
        String name = inuptName();
        System.out.println("Hello, " + name + "!");
        System.out.println(ruleOfGame);
    }

}
