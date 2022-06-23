package lesson7;

/*
Java. Уровень 1. Урок 7. Практика ООП и работа со строками.

1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/

public class Main {

    private static int TIME = 0;

    public static void main(String[] args) {
        Cat[] cat = new Cat[4];
        cat[0] = new Cat("Juanito", 200, 5);
        cat[1] = new Cat("Pablito", 100, 3);
        cat[2] = new Cat("Amando", 70, 2);
        cat[3] = new Cat("Felix", 30, 1);
        Plate plate = new Plate(800);
        System.out.println("У нас есть четыре вечноголодных кота: " + cat[0].getName() + ", " + cat[1].getName() + ", " + cat[2].getName() + " и " + cat[3].getName() + ", которые хотят есть каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + ", " + cat[2].getSatietyTime() + " и " + cat[3].getSatietyTime() + " час.");
        System.out.println("В миске находится " + plate.getFood() + " грамм кошачьего корма. Все коты очень голодны и собираются поесть.\n");

        do {
            for (Cat i : cat) {
                if (i.getSatiety() == 0) {

                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и будет снова голоден через " + (i.getSatiety()) + " часа)");
                }

                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента начала кормления прошло " + TIME + " часа. Корма осталось " + plate.getFood() + " граммов.\n");
            TIME++;

        } while (TIME <= 24);
    }
}
