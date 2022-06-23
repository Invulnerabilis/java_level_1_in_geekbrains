package lesson7;

public class Plate {
    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 400;
        System.out.println("В миску добавили ещё 700 грамм корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}
