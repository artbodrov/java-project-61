package hexlet.code.games;

import java.util.Random;

public class GCD {

    public static String theGame() {
        Random random = new Random();
        int num1 = random.nextInt(99) + 1;
        int num2 = random.nextInt(99) + 1;
        System.out.println(num1 + " " + num2);
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        String result = String.valueOf(num1 + num2);

        return result;
    }
}