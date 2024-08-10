import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scn1 = new Scanner(System.in);
        System.out.print("Введите первую фамилию: ");
        String lgn1 = scn1.nextLine();
        System.out.println(lgn1.length());
        Scanner scn2 = new Scanner(System.in);
        System.out.print("Введите вторую фамилию: ");
        String lgn2 = scn2.nextLine();
        System.out.println(lgn2.length());

       if (lgn1.length() > lgn2.length() ) {
        String hlp = "Lastname %s greater then %s";
        String hlp2 = String.format(hlp, lgn1 , lgn2 );
        System.out.println(hlp2);
     
       }
       else if ( lgn1.length() < lgn2.length()) {
           String hlp = "Lastname %s greater then %s";
           String hlp2 = String.format(hlp, lgn2, lgn1);
           System.out.println(hlp2);

       }


    }
    
}
