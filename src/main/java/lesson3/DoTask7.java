package lesson3;

public class DoTask7 {
    public static void main(String[] args) {
        int[] array = {1, 1, 3, 4, 7, 2};
//        checkBalance([1, 1, 3, 4,||| 7, 2]) → true, т.е. 1 + 1 + 3 + 4 = 7 + 2
        System.out.println(checkBalance(array));
    }

    public static boolean checkBalance(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            if (leftSum * 2 == sum) {
                return true;
            }
            if (leftSum * 2 > sum) {
                return false;
            }
        }
        return false;
    }
}
