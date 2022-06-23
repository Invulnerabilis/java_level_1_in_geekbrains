package lesson3;

import java.util.Arrays;

public class DoTask4 {
    private static final int SIZE = 7;

    public static void main(String[] args) {
        int[][] array = new int[SIZE][SIZE];
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            array[i][i] = array[i][lastIndex - i] = 1;
        }

        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
