import java.util.Scanner;

public class Task4 {
    
    public static double maxDifference(double x, double y, double z) {
        return Math.max(Math.abs(x - y), Math.max(Math.abs(y - z), Math.abs(z - x)));
    }

    
    public static boolean isPythagoreanTriple(int x, int y, int z) {
        return x * x + y * y == z * z || y * y + z * z == x * x || z * z + x * x == y * y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.print("Введите третье число: ");
        double num3 = scanner.nextDouble();

        scanner.close();

        
        double maxDiff = maxDifference(num1, num2, num3);
        boolean isPythagorean = isPythagoreanTriple((int) num1, (int) num2, (int) num3);

        System.out.println("Максимальная разница: " + maxDiff);
        System.out.println("Пифагорова тройка: " + isPythagorean);
    }
}
