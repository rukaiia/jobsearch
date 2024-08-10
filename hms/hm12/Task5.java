import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Random random = new Random();

        int days = random.nextInt(15) + 1;

        int[] rainfall = new int[days];

       
        for (int i = 0; i < days; i++) {
            rainfall[i] = random.nextInt(51); 
        }

        double averageRainfall = calculateAverage(rainfall);

        int maxRainfallDay = findMaxRainfallDay(rainfall);

        System.out.printf("Среднедневное количество осадков: %.2f%n", averageRainfall);
        System.out.printf("День с максимальным количеством осадков: %d (%d мм)%n", maxRainfallDay + 1,
                rainfall[maxRainfallDay]);
    }

    private static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    private static int findMaxRainfallDay(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }
}
