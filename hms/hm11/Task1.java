import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите название футбольного клуба: ");
        String lng = scn.nextLine();
        System.out.println(lng.length());
        System.out.println(lng.toUpperCase());
        System.out.println(lng.toLowerCase());
    }
}