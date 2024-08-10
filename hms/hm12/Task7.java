import java.util.Arrays;
import java.util.Random;

public class Task7 {
    public static void main(String[] args) {
        Random random = new Random();

        int numberOfBoxers = random.nextInt(16) + 10;
        int[] boxerWeights = new int[numberOfBoxers];
        for (int i = 0; i < numberOfBoxers; i++) {
            boxerWeights[i] = random.nextInt(51) + 40; // 40 + [0, 50]
        }

        System.out.println("Массив массы боксеров: " + Arrays.toString(boxerWeights));
        int lightweightCount = 0,
                welterweightCount = 0,
                middleweightCount = 0,
                lightHeavyweightCount = 0;
                
        for (int weight : boxerWeights) {
            if (weight < 0) {
                System.out.println("Ошибка: Вес не может быть отрицательным.");
                return;
            } else if (weight <= 63) {
                lightweightCount++;
            } else if (weight <= 69) {
                welterweightCount++;
            } else if (weight <= 75) {
                middleweightCount++;
            } else if (weight <= 81) {
                lightHeavyweightCount++;
            }
        }

        System.out.println("Количество боксеров в легком весе: " + lightweightCount);
        System.out.println("Количество боксеров в полусреднем весе: " + welterweightCount);
        System.out.println("Количество боксеров в среднем весе: " + middleweightCount);
        System.out.println("Количество боксеров в полутяжелом весе: " + lightHeavyweightCount);
    }
}
