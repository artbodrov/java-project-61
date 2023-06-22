package hexlet.code.games;

import java.util.Random;

public class Prime {
    public static String theGame() {
        Random random = new Random();
        int number = random.nextInt(99) + 2;
        String result = "WTF";
        if (number % 2 == 0) {
            result = "no";
        } else {
            for (int j = 3; j * j <= number; j += 2) {
                if (number % j == 0) {
                    result = "no";
                } else {
                    result = "yes";
                }
            }
        }
        System.out.println(number);
        return result;
    }
}

