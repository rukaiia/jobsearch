import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите скорость в км/час: ");
        double kmPerHour = scanner.nextDouble();

        System.out.print("Введите скорость в м/сек: ");
        double mPerSecond = scanner.nextDouble();

        if (kmPerHour > mPerSecond) {
            System.out.println("Скорость в км/час больше, чем в м/сек.");
        } else if (kmPerHour < mPerSecond) {
            System.out.println("Скорость в м/сек больше, чем в км/час.");
        } else {
            System.out.println("Скорости равны.");
        }

        
    }
}
