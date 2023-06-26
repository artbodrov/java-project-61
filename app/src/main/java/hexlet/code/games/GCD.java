package hexlet.code.games;

import java.util.Random;

public class GCD {

    public static String theGame() {
        int j = 99;
        int k = 99;
        Random random = new Random();
        int num1 = random.nextInt(j) + 1;
        int num2 = random.nextInt(k) + 1;
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
