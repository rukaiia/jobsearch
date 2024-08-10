import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
       
        Random random = new Random();
        int size = random.nextInt(15) + 1; 
        int[] fibonacci= new int[size];

        fibonacci[0] = 1;
        if (size > 1) {
            fibonacci[1] = 1;
        }

       
        for (int i = 2; i < size; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println("Массив в прямом порядке: " + Arrays.toString(fibonacci));

        System.out.print("Массив в обратном порядке: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}
