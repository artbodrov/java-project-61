package hexlet.code.games;

import java.util.Random;

public class Progression {

    public static String theGame() {
        Random random = new Random();
        int num1 = random.nextInt(9) + 1;
        int num2 = random.nextInt(9) + 1;
        int number = random.nextInt(9) + 1;
        int[] arr = new int[10];
        arr[0] = num1;
        for (var j = 1; j <= arr.length - 1; j++) {
            arr[j] = arr[j - 1] + num2;
        }
        for (var j = 0; j < arr.length; j++) {
            if (j == number) {
                System.out.print(".. ");
            } else {
                System.out.print(arr[j] + " ");
            }
        }
        System.out.println();
        String result = String.valueOf(arr[number]);
        return result;
    }
}

