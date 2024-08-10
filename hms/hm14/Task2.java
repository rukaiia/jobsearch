
    
import java.util.Arrays;

public class Task2 {
  
    public static int[] reverseSign(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = -array[i];
        }
        return result;
    }

    public static void main(String[] args) {
      
        int[] originalArray = { 1, 2, 3, 4, 5 };

       
        System.out.println("Исходный массив:");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        
        int[] newArray = reverseSign(originalArray);

        System.out.println("Массив после изменения:");
        for (int num : newArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
    

