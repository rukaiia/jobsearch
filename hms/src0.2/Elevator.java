import java.util.Random;
import java.util.Scanner;

class Elevator {
    private int currentFloor;
    private final int capacity;
    static final int maxFloor = 18;

    public Elevator(int currentFloor, int capacity) {
        this.currentFloor = currentFloor;
        this.capacity = capacity;
    }

    public void move(int toFloor) {
        if (!isAllowableFloor(toFloor)) {
            System.out.println("Ошибка: Недопустимый этаж.");
            return;
        }

        System.out.println("Лифт начинает движение...");

        Random random = new Random();
        int chanceToStuck = random.nextInt(3); // Вероятность застревания - 1 к 3

        if (toFloor > currentFloor) {
            for (int i = currentFloor + 1; i <= toFloor; i++) {
                System.out.println("Лифт проезжает " + i + " этаж.");
                currentFloor = i;
                if (chanceToStuck == 0 && i < toFloor) {
                    System.out.println("Лифт застрял на " + i + " этаже!");
                    return;
                }
            }
        } else if (toFloor < currentFloor) {
            for (int i = currentFloor - 1; i >= toFloor; i--) {
                System.out.println("Лифт проезжает " + i + " этаж.");
                currentFloor = i;
                if (chanceToStuck == 0 && i > toFloor) {
                    System.out.println("Лифт застрял на " + i + " этаже!");
                    return;
                }
            }
        }

        System.out.println("Лифт прибыл на " + toFloor + " этаж.");
    }

    public boolean isAllowableWeight(int weight) {
        return weight <= capacity;
    }

    public boolean isAllowableFloor(int floor) {
        return floor >= 1 && floor <= maxFloor;
    }
}
