package lesson6;

public class Dog extends Animals {
    public static int dogCount;

    public Dog(String name) {
        this.name = name;
        this.type = "собака";
        this.maxRunDistance = 80;
        this.maxSwimDistance = 15;
        dogCount++;
    }
}
