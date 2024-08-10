import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    public static Random rnd = new Random();
    public static char[] encodedWord;

    public static int points = 0;
    public static int attemts = 3;
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            tourLaunch();
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
            
        
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    
    }
    
    public static void tourLaunch() {
        for (int i = 0; i < 3; i++){
            String[] words = selectCategory();
            print(Arrays.toString(words));

            String word = selectWord(words);
            print(word);

            getEncodedWord(word);
            print(Arrays.toString(encodedWord));

            while (checkEncodedWord() && attemts > 0) {
                char letter = chooseLetter();
               
                print(Arrays.toString(encodedWord));

                if (replaceLetterInEncodedWord(letter, word)) {
                    print("Такой буквы нет");
                    attemts--;
                }
                print(Arrays.toString(encodedWord));
            }
            print("Game over");
            print("Word: " + word);
            print("Score: " + points);
        }
        
        

    }

    public static String[] selectCategory() {
        String[] categories = { "Animals", "Cities", "Fruits" };
        String[] array;

        switch (rnd.nextInt(categories.length)) {
            case 0:
                array = new String[] { "Elephant", "Cat", "Giraffe" };
                print("Category: " + categories[0]);
                break;

            case 1:
                array = new String[] { "Moscow", "Rio", "Bishkek" };
                print("Category: " + categories[1]);
                break;

            case 2:
            default:
                array = new String[] { "Banana", "Mango", "Apple" };
                print("Category: " + categories[2]);
                break;
        }
        return array;

    }
      
    
    public static void print(String message) {
        System.out.println(message);
    }

    public static String selectWord(String[] words) {
        return words[rnd.nextInt(words.length)];
    }

    public static void getEncodedWord(String word) {
        encodedWord = new char[word.length()];
        Arrays.fill(encodedWord, '*');
    }

    public static char chooseLetter() {
        Scanner sc = new Scanner(System.in);

        String str;

        while (true) {
            print("Enter letter: ");
            str = sc.nextLine();

            if (!str.isEmpty()) {
                break;
            }
            print("Letter can not be empty! Try again");
        }
        return str.charAt(0);
    }

    public static boolean replaceLetterInEncodedWord(char letter, String word) {
        String str = String.valueOf(letter);
        boolean bool = true;
        for (int i = 0; i < word.length(); i++) {
            if (str.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                encodedWord[i] = letter;
                bool = false;
                points++;
            }
            ;

        }
        return bool;

    }

    public static boolean checkEncodedWord() {
        for (int i = 0; i < encodedWord.length; i++) {
            if (encodedWord[i] == '*') {
                return true;
            }
        }
        return false;
    }
   
}
