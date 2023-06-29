package hexlet.code.games;

import java.util.Random;

public class Calc {

    private static String ruleOfGame = "What is the result of the expression?";
    private static final int FIRST_RANGE = 9;
    private static final int SECOND_RANGE = 9;

    public static String theGame() {

        int number = 0;

        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        int randomOperatorIndex = new java.util.Random().nextInt(operators.length);
        int num1 = random.nextInt(FIRST_RANGE) + 1;
        int num2 = random.nextInt(SECOND_RANGE) + 1;

        switch (randomOperatorIndex) {
            case 0 -> {
                System.out.println(num1 + " + " + num2);
                number = num1 + num2;
            }
            case 1 -> {
                System.out.println(num1 + " - " + num2);
                number = num1 - num2;
            }
            case 2 -> {
                System.out.println(num1 + " * " + num2);
                number = num1 * num2;
            }
            default -> System.out.println("Oh... really?!!");
        }
        String result = String.valueOf(number);
        return result;
    }
    public static String ruleOfGame(){

        return ruleOfGame;
    }
}
