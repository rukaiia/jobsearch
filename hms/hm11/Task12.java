
    
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите операцию (+, -, *, /, %): ");
        String operation = scanner.nextLine().toLowerCase();

        System.out.println("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.println("Введите второе число: ");
        double num2 = scanner.nextDouble();

        double result;
                result = num1 + num2;
                System.out.printf("Результат: %.2f %s %.2f = %.2f%n", num1, "плюс", num2, result);

                result = num1 - num2;
                System.out.printf("Результат: %.2f %s %.2f = %.2f%n", num1, "минус", num2, result);

                result = num1 * num2;
                System.out.printf("Результат: %.2f %s %.2f = %.2f%n", num1, "умножить на", num2, result);

                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.printf("Результат: %.2f %s %.2f = %.2f%n", num1, "делить на", num2, result);
                } else {
                    System.out.println("Деление на ноль недопустимо!");
                }
              
           
                if (num2 != 0) {
                    result = num1 % num2;
                    System.out.printf("Результат: %.2f %s %.2f = %.2f%n", num1, "по модулю", num2, result);
                } else {
                    System.out.println("Деление на ноль недопустимо!");
                }
              
                System.out.println("Я не знаю такую операцию!");
        }

       
    }

    

