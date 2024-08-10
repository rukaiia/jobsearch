
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число от 1 до 9:");

       
        double number;
        while (true) {
            number = scanner.nextDouble();
            if (number >= 1 && number <= 9) {
                break;
            } else {
                System.out.println("Пожалуйста, введите число от 1 до 9:");
            }
        }

       
        for (int i = 1; i <= 9; i++) {
            double result = number * i;
            System.out.printf("%.1f * %d = %.1f%n", number, i, result);
        }

        
       
    }
}
