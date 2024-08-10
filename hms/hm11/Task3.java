import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
       
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the value of x: ");
        double x = scn.nextDouble();

        double result;

        if (x < 0) {
            result = 3 * x + 1;
        } else if (x == 0) {
            result = Math.cos(x);
        } else {
            result = Math.sin(x);
        }

        System.out.println("The result of the function F(x, y) is: " + result);

       
    }
}

    
