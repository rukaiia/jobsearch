import java.util.Scanner;
import java.util.Random;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий этаж: ");
        int currentFloor = scanner.nextInt();

        System.out.print("Введите максимальный вес лифта (не более 200): ");
        int capacity = scanner.nextInt();
        if (capacity > 200) {
            System.out.println("Ошибка: Превышен максимальный вес лифта.");
            return;
        }

        Elevator elevator = new Elevator(currentFloor, capacity);

        while (true) {
            System.out.print("\nНа какой этаж нужно переместить лифт (1-" + Elevator.maxFloor + "): ");
            int toFloor = scanner.nextInt();

            System.out.print("Введите вес, который нужно перевезти: ");
            int weight = scanner.nextInt();

            if (!elevator.isAllowableWeight(weight)) {
                System.out.println("Ошибка: Превышен максимальный вес.");
                continue;
            }

            elevator.move(toFloor);
        }
    }
}


