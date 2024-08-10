import java.util.Arrays;
import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        Random random = new Random();

        int size = random.nextInt(10) + 1;

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(21) - 10; 
        }
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        System.out.print("Неотрицательные элементы: ");
        for (int number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
        System.out.print("Отрицательные элементы: ");
        for (int number : numbers) {
            if (number < 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        System.out.print("Элементы на четных местах: ");
        for (int i = 0; i < size; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.print("Элементы на нечетных местах: ");
        for (int i = 1; i < size; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int positiveCount = 0;
        int negativeCount = 0;

        for (int number : numbers) {
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            }
        }

        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
    }
}
