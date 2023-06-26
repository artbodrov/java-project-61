package hexlet.code.games;

import java.util.Random;

public class Prime {
    public static String theGame() {
        Random random = new Random();
        String result = "WTF";
        int number = random.nextInt(99) + 2;

        if (number <= 1) {
            result = "no";
        }
        if (number == 2 || number == 3) {
            result = "yes";
        }
        if (number % 2 == 0 || number % 3 == 0) {
            result = "no";
        }
        for (int i = 5; i <= Math.sqrt(number); i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                result = "no";
            } else {
                result = "yes";
            }
        }
        System.out.println(number);
        return result;
    }
}

