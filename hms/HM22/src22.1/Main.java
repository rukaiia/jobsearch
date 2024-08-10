import java.util.Scanner;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Заполните данные о сотруднике.");

        String name = enterName(scanner);
        String surname = enterSurname(scanner);

        int birthYear = enterYear(scanner, "Введите год рождения:");
        int startYear = enterYear(scanner, "Введите год начала работы:");

        Employee employee = new Employee(name, surname, birthYear, startYear);
        try {
            int experience = employee.calculateExperience();
            System.out.println("Общий рабочий стаж сотрудника: " + experience + " лет.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static String enterName(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        if (name.matches(".*\\d.*")) {
            System.out.println("Ошибка: Имя не должно содержать числа.");
            return enterName(scanner);
        }
        return name;
    }

    private static String enterSurname(Scanner scanner) {
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        if (surname.matches(".*\\d.*")) {
            System.out.println("Ошибка: Фамилия не должна содержать числа.");
            return enterSurname(scanner);
        }
        return surname;
    }

    private static int enterYear(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.println(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите год числом.");
            }
        }
    }
}








