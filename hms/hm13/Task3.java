import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите год: ");
        int year = scn.nextInt();

        String[] colors = {"Зеленый", "Красный", "Желтый", "Белый" ,"Ченый"};
        String[] animals = { "крысы" , "коровы" , "тигра" ,"зайца" ,"дрокона", "змеи" , "лошоди", "овцы" , "обезьяны" , "курицы" , "собаки" , "свиньи"};

        String color = colors[year % 5];
        String animal = animals[year % 12];
        System.out.println(color + ",  " + "год " + animal ); 
    }

}
