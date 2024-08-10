import java.text.DecimalFormat;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int[] salaries1 = new int[5];
        Scanner scn = new Scanner(System.in);
        int sum = 0;

       
        for (int i = 0; i < salaries1.length; i++) {
            System.out.println("Введите зарплату: ");
            int value = scn.nextInt();
            salaries1[i] = value;

            sum += salaries1[i];
        }

       
        int min = salaries1[0];
        int max = salaries1[0];

        for (int i = 0; i < salaries1.length; i++) {
            if (salaries1[i] < min) {
                min = salaries1[i];
            }
            if (salaries1[i] > max) {
                max = salaries1[i];
            }
        }

        
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println("Общая сумма: " + formatter.format(sum));
        System.out.println("Максимальный оклад: " + formatter.format(max));
        System.out.println("Минимальный оклад: " + formatter.format(min));
        System.out.println("Разница: " + formatter.format(max - min));
    }
}
