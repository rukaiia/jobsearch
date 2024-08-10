import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите высоту башни (от 0 до 12): ");
        int height = scanner.nextInt();
        System.out.print("На каком уровне стоит человечек? (от 0 до высоты башни): ");
        int personLevel = scanner.nextInt();

        if (height < 0 || height > 12 || personLevel < 0 || personLevel > height) {
            System.out.println("Некорректный ввод.");
            return;
        }

        String[] tower = new String[height + 1];

        for (int i = 0; i <= height; i++) {
            StringBuilder level = new StringBuilder();

            for (int j = 0; j < height - i; j++) {
                level.append(" ");
            }
            level.append("##");
            for (int j = 0; j < 2 * i; j++) {
                level.append("#");
            }

            if (i == personLevel) {
                level.append(" @");
            }
            tower[i] = level.toString();
        }
        for (int i = 0; i <= height; i++) {
            System.out.println(tower[i]);
        }
    }
}
