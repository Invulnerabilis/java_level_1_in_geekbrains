package lesson1;

/*
Java. Уровень 1. Урок 1. Введение.

1. Создать пустой проект в IntelliJ IDEA, создать класс HomeWorkApp, и прописать в нем метод main().
2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
Orange
Banana
Apple

3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
Методы из пунктов 2-5 вызовите из метода main() и посмотрите корректно ли они работают.
Если выполнение задач вызывает трудности, можете обратиться к последней главе методического пособия “Подсказки по домашнему заданию”.

Дополнительные материалы
К. Сьерра, Б. Бейтс Изучаем Java // Пер. с англ. – М.: Эксмо, 2012. – 720 с.
Кей С. Хорстманн, Гари Корнелл Java. Библиотека профессионала. Том 1. Основы // Пер. с англ. – М.: Вильямс, 2014. - 864 с.
Если набрались опыта в написании кода на Java и хотите понять основы Git
Подсказки по домашнему заданию
Как быть если вы посмотрели вебинар, прочитали методичку, посмотрели на домашнее задание и не понимаете как к нему подойти? Это не страшно, такое вполне возможно, каждый из нас когда-то начинал учиться программировать с нуля. Давайте попробуем вместе выполнить похожее домашнее задание.

Создать пустой проект в IntelliJ IDEA, создать класс HomeWorkApp, и прописать в нем метод main().
Для выполнения этого задание повторите за преподавателем процесс создания проекта и создайте новый класс с указанным именем. Должно получиться что-то вроде:
public class HomeWorkApp {
}

Замечательно, переходим к пункту 2.

Создайте метод drawSquare(), который при вызове должен отпечатать рисунок квадрата. *(Вы же не думали что мы будем решать именно ваше дз?)
Квадрат наверное может выглядеть вот так:
| |
Как это превратить в код?

public class HomeWorkApp {
public static void main(String[] args) {
drawSquare();
}

public static void drawSquare() {
System.out.println("-----");
System.out.println("| |");
System.out.println("-----");
}
}

Ну вот, ничего сложного. Метод создали, хорошее имя ему дали, сказали что при вызове он должен отпечатать в консоль три строки. Чтобы проверить корректность, да и вообще чтобы метод был выполнен, мы вызвали его из метода main().

Создайте метод checkHomework() в теле которого объявлена int переменная tasksCount (количество выполненных задач). В зависимости от значения переменной, метод должен напечатать в консоль оценку студента.
public class HomeWorkApp {
public static void main(String[] args) {
checkHomework();
}

public static void checkHomework() {
int tasksCount = 3;

  if (takskCount == 6) {
     System.out.println("Великолепно, Вы выполнили все задачи!");
  }
  if (tasksCount > 3 && tasksCount < 6) {
     System.out.println("Отлично, Вы выполнили почти все задачи!");
  }
  if (tasksCount <= 3) {
     System.out.println("Вы решили меньше половины, но Вы все равно молодец, надо же с чего-то начинать!!");
  }

  System.out.println("Проверка завершена");
}
}

В данном случае мы добавили к формулировке дз немного творчества (так делать не надо), это сделано для того, чтобы показать вам как текстовая формулировка задачи может преобразовываться в код. Кроме того, корректнее было бы использовать конструкцию if-else-if, но мы же смотрим пока самые простые варианты.

Создайте метод howIsTheWeatherThere() в теле которого объявлена int переменная temperature. В зависимости от значения переменной, метод должен оценить погоду на улице.
public class HomeWorkApp {
public static void main(String[] args) {
howIsTheWeatherThere();
}

public static void howIsTheWeatherThere() {
int temperature = 15;

  if (temperature > 10) {
     System.out.println("На улице очень даже тепло для марта месяца");
  } else if (temperature > -5) {
     System.out.println("Для марта самое то");
  } else {
     System.out.println("Там точно весна?");
  }
}
}

Заметка.
Как собрать решение всех задач вместе? А вот так:

public class HomeWorkApp {
public static void main(String[] args) {
drawSquare();

checkHomework();
howIsTheWeatherThere();
}

public static void drawSquare() {
System.out.println("-----");
System.out.println("| |");
System.out.println("-----");
}

public static void checkHomework() {
int tasksCount = 3;

  if (takskCount == 6) {
     System.out.println("Великолепно, Вы выполнили все задачи!");
  }
  if (tasksCount > 3 && tasksCount < 6) {
     System.out.println("Отлично, Вы выполнили почти все задачи!");
  }
  if (tasksCount <= 3) {
     System.out.println("Вы решили меньше половины, но Вы все равно молодец, надо же с чего-то начинать!!");
  }

  System.out.println("Проверка завершена");
}

public static void howIsTheWeatherThere() {
int temperature = 15;

  if (temperature > 10) {
     System.out.println("На улице очень даже тепло для марта месяца");
  } else if (temperature > -5) {
     System.out.println("Для марта самое то");
  } else {
     System.out.println("А там точно весна?");
  }
}
}

При запуске программы начинает выполняться метод main(), который в свою очередь последовательно выполняет каждый из методов, так как мы их вызываем в теле метода main().
*/

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        /*
        checkSumSign();
        printColor();
        */
        compareNumbers();
    }

    static void compareNumbers() {
        int a = 7;
        int b = 5;

        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static void printColor() {
        int value = 120;

        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }

    public static void checkSumSign() {
        int a = 2;
        int b = 5;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
}
