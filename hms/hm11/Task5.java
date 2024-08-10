import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Введите радиус круга: ");
        double radius = scn.nextDouble();

        System.out.print("Введите сторону квадрата: ");
        double side = scn.nextDouble();

        double circleArea = Math.PI * Math.pow(radius, 2);
        double squareArea = Math.pow(side, 2);

        if (circleArea > squareArea) {
            System.out.println("Площадь круга больше, чем площадь квадрата.");
        } else if (circleArea < squareArea) {
            System.out.println("Площадь квадрата больше, чем площадь круга.");
        } else {
            System.out.println("Площади равны.");
        }

      
    }
}
