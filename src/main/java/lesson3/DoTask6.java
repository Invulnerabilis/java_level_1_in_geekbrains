package lesson3;

import java.util.Arrays;

public class DoTask6 {

    public static void main(String[] args) {
        int[] array = {9, 7, 4, 1, 5, 8, 3};
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
