package lesson8;

/*
Java. Уровень 1. Урок 8. Написание приложения с графическим интерфейсом.

Доработать проект калькулятора чтобы производил сами расчёты при нажатие на знак равенство.

Добавить кнопки "." и "С".

Сделать посимвольное удаление стрелочкой назад чтобы стерать введённые данные.

Запретить возможность изменения размера окна.

Сделать работу меню "File": при нажатии на About чтобы выводилось имя автора проекта, добавить туда же опцию "Clear" и "Exit".

Придать более приятный внешний вид калькулятора.
*/

public class Main {
    public static void main(String[] args) {
        new ApplicationForms("My first calculator");
    }
}