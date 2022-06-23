package lesson3;

import java.util.Arrays;

public class DoTask8 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        foo(a, -2);
        System.out.println(Arrays.toString(a));


    }

    public static void foo(int[] arr, int n) {
        int temp;
        int len = arr.length - 1;
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                temp = arr[0];
                System.arraycopy(arr, 1, arr, 0, len);
                arr[len] = temp;
            }
        } else {
            for (int i = 0; i < n; i++) {
                temp = arr[len];
                System.arraycopy(arr, 0, arr, 1, len);
                arr[0] = temp;
            }
        }
    }
}
