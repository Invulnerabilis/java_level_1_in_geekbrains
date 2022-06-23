package lesson3;

public class DoTask5 {
    public static void main(String[] args) {

    }

    public static int[] doTask5(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
