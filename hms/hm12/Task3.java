import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        int size = 12;

        int[] heights = new int[size];

        Random random = new Random();


        for (int i = 0; i < size; i++) {
            heights[i] = random.nextInt(28) + 163;
        }

        System.out.println("Исходный массив ростов: " + Arrays.toString(heights));
        Arrays.sort(heights);
        System.out.println("Отсортированный массив ростов: " + Arrays.toString(heights));
        
        }
 }