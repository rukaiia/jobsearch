import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты точки в формате (x y):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

       
        if (x == 0 || y == 0) {
            System.out.println("На границе");
        } else {
           
            if (x > 0 && y > 0) {
                System.out.println("I область");
            } else {
                System.out.println("II область");
            }
        }
    }
}
