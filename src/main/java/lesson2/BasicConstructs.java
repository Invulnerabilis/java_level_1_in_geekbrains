package lesson2;

/*
Java. Уровень 1. Урок 2. Основные конструкции.

1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
Если выполнение задач вызывает трудности, можете обратиться к последней странице методического пособия. Для задач со * не нужно искать решение в интернете, иначе нет смысла их выполнять.
*/

public class BasicConstructs {
    public static void main(String[] args) {

    }

    public static boolean betweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
/* На такое решение мне IDEA предложила сделать так:
return sum >= 10 && sum <= 20;
но у меня нет понимания почему сразу можно прописать возврат и поэтому я оставил как мне кажется верным
 */
    }

    public static void printTheNumber(int number) {
        if(number >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    public static boolean thisIsNegative(int number) {
        if(number < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printLineXTimes(String line, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(line);
        }
    }

    public static boolean checkYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
