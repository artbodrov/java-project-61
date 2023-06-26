package hexlet.code.games;

import java.util.Random;

public class Prime {
    public static boolean isPrime() {
        int j = 99;
        Random random = new Random();
        int number = random.nextInt(j) + 2;
        System.out.println(number);
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String theGame() {
        boolean flag = true;
        String result = "WTF";
        if (flag == isPrime()) {
            result = "yes";
        } else {
            result = "no";
        }

        return result;
    }
}

