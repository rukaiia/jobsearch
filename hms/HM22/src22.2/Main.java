import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите фигуру: ");
        System.out.println("1. Параллелепипед");
        System.out.println("2. Сфера");
        System.out.println("3. Цилиндр");
        System.out.println("4. Конус");


        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите число от 1 до 4.");
            return;
        }


        switch (choice) {
            case 1:
                Shapes.calculateParallelepiped(scanner);
                break;
            case 2:
                Shapes.calculateSphere(scanner);
                break;
            case 3:
                Shapes.calculateCylinder(scanner);
                break;
            case 4:
                Shapes.calculateCone(scanner);
                break;
            default:
                System.out.println("Ошибка: Неверный выбор.");
        }

    }

}
