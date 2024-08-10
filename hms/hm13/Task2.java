
    
import java.util.Scanner;

public class Task2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число N: ");
        int N = scanner.nextInt();
        int num = 0;

       
        if (N < 10 || N > 1000000) {
            System.out.println("Число должно быть от 10 до 1,000,000.");
            return;
        }

        String nmb = Integer.toString(N);

    
        int[] str = new int[nmb.length()];


        for (int i = 0; i < str.length; i++) {
            str[i] = Character.getNumericValue(nmb.charAt(i));
            num += str[i];

        }

 
        System.out.println("Число " + N + " разбито на цифры и записано в массив:");
        for (int digit : str) {
            System.out.println(digit + " ");
        }
         
        int digit2 = nmb.length();
        System.out.println("Кол-во цифр в числе: " + digit2);


        System.out.println("Сумма всех цифр: " + num);
        for (int digit : str) {
            if ( digit % 2 == 0 ){
                System.out.println("Четные числа: " + digit + " ");
            }
        }
        for (int digit : str) {
            if (digit % 2 == 1) {
                System.out.println("Нечетные числа: " +  digit + " ");
            }
        }
        int minDigit = Integer.MAX_VALUE; 
        int maxDigit = Integer.MIN_VALUE; 

        for (int i = 0; i < nmb.length(); i++) {
            int digit = Character.getNumericValue(nmb.charAt(i));
            minDigit = Math.min(minDigit, digit); 
            maxDigit = Math.max(maxDigit, digit); 
        }
        double average = (minDigit + maxDigit) / 2.0;
        

        System.out.println("Минимальная цифра: " + minDigit);
        System.out.println("Максимальная цифра: " + maxDigit);
        System.out.println("Среднее арифметическое минимальной и максимальной цифр: " + average);
    }
}
    


