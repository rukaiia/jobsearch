import java.util.Scanner;

public class Task3 {
    
    public static void readNumbers() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (true) {
            System.out.print("Введите число (для завершения введите 0): ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
            count++;
        }
        
        
        if (count == 0) {
            System.out.println("Вы не ввели ни одного числа.");
        } else {
            
            printResults(sum, count);
        }
    }

    
    public static void printResults(int sum, int count) {
        System.out.println("Вы ввели " + count + " чисел.");
        System.out.println("Их сумма составляет " + sum);
        double average = (double) sum / count;
        System.out.println("Среднее арифметическое чисел: " + average);
    }

    public static void main(String[] args) {
        System.out.println("Введите числа. Введите 0 для остановки.");
      
        readNumbers();
    }
}
