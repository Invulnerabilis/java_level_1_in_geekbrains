package lesson6;

public class Cat extends Animals {
    public static int catCount;

    public Cat(String name) {
        this.name = name;
        this.type = "кот";
        this.maxRunDistance = 50;
        this.maxSwimDistance = 0;
        catCount++;
    }
}
