package lesson5;

/*
Java. Уровень 1. Урок 5. Введение в ООП.

1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

public class MainApp {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Pavel", "Engineer", "pavel@gmail.com", 7564231, 30, 100000),
                new Employee("Sergey", "Painter", "sergey@gmail.com", 7651243, 42, 125000),
                new Employee("Elena", "Sales Manager", "elena@gmail.com", 7456321, 20, 85000),
                new Employee("Irina", "Lead Developer", "irina@gmail.com", 7654123, 45, 110000),
                new Employee("Anna", "Procurement Specialist", "anna@gmail.com", 7651234, 22, 90000),
        };


        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].info();
                System.out.println(employees);
            }
        }
    }
}
