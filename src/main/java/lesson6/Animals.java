package lesson6;

public abstract class Animals {
    public static int animalsCount;

    String type;
    String name;
    int maxSwimDistance;
    int maxRunDistance;

    public Animals() {
        animalsCount++;
    }

    public void run(int distance) {
        if (distance < maxRunDistance) {
            System.out.println(type + " " + name + " " + "пробежал(а) дистанцию\n");
        } else {
            System.out.println(type + " " + name + " " + "не смог пробежать\n");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " " + "не умеет плавать! Берегите животных!\n");
            return;
        }
        if (distance < maxSwimDistance) {
            System.out.println(type + " " + name + " " + "проплыла дистанцию\n");
        } else {
            System.out.println(type + " " + name + " " + "не смогла проплыть\n");
        }
    }
}
