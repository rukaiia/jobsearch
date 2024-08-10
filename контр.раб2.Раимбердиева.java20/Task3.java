import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Start game");
        Scanner scn = new Scanner(System.in);

        String answer;
        do {
            playGame(scn);
            System.out.print("Do you want to play one more time? (yes/no): ");
            answer = scn.next();
        } while (answer.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing. Goodbye!");
    }

    public static void playGame(Scanner scn) {
        System.out.println("\nStart game");

        int userTotalPoints = 0;
        int computerTotalPoints = 0;

        Random rnd = new Random();

        int[] userPredictions = new int[3];
        int[] computerPredictions = new int[3];
        int[] userDice1 = new int[3];
        int[] userDice2 = new int[3];
        int[] computerDice1 = new int[3];
        int[] computerDice2 = new int[3];
        int[] userResults = new int[3];
        int[] computerResults = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nRound " + (i + 1) + ":");
            System.out.print("Predict amount of points (2 .. 12): ");
            int num = scn.nextInt();

            int dice1 = rollTheDice(rnd);
            int dice2 = rollTheDice(rnd);

            System.out.println("User rolls the dice...");
            printDice(dice1);
            printDice(dice2);
            int userPoints = dice1 + dice2;

            int userResult = userPoints - Math.abs(userPoints - num) * 2;
            userTotalPoints += userResult;

            System.out.print("Predict amount of points (2 .. 12): ");
            int num2 = scn.nextInt(11);

            int dice3 = rollTheDice(rnd);
            int dice4 = rollTheDice(rnd);

            System.out.println("Computer rolls the dice...");
            printDice(dice3);
            printDice(dice4);
            int computerPoints = dice3 + dice4;

            int computerResult = computerPoints - Math.abs(computerPoints - num2) * 2;
            computerTotalPoints += computerResult;

            userPredictions[i] = num;
            computerPredictions[i] = num2;
            userDice1[i] = dice1;
            userDice2[i] = dice2;
            computerDice1[i] = dice3;
            computerDice2[i] = dice4;
            userResults[i] = userResult;
            computerResults[i] = computerResult;

            int difference = userTotalPoints - computerTotalPoints;
            System.out.println("\n---------- Current score ---------");
            System.out.println("User: " + userTotalPoints + " points");
            System.out.println("Computer: " + computerTotalPoints + " points");
            if (difference > 0) {
                System.out.println("User is ahead by " + difference + " points!");
            } else if (difference < 0) {
                System.out.println("Computer is ahead by " + Math.abs(difference) + " points!");
            } else {
                System.out.println("The score is tied!");
            }
        }

        System.out.println("\n-------------- Finish game --------------");
        System.out.println("Round | User | Computer");
        System.out.println("------+------|---------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("  -%d- |", i + 1);
            System.out.printf(" Predicted: %d |", userPredictions[i]);
            System.out.printf(" Predicted: %d |", computerPredictions[i]);
            System.out.println();
            System.out.printf("       | Dice: %d, %d |", userDice1[i], userDice2[i]);
            System.out.printf(" Dice: %d, %d |", computerDice1[i], computerDice2[i]);
            System.out.println();
            System.out.printf("       | Result: %d |", userResults[i]);
            System.out.printf(" Result: %d |", computerResults[i]);
            System.out.println();

            System.out.println("------+-------------------+----------------");
        }
        System.out.println("Total | Points: " + userTotalPoints + " | Points: " + computerTotalPoints);

        int difference = userTotalPoints - computerTotalPoints;
        if (difference > 0) {
            System.out.println("Users win " + difference + " points more. Congratulations!");
        } else if (difference < 0) {
            System.out.println("Computer wins " + Math.abs(difference) + " points more. Congratulations!");
            } else {
            System.out.println("It's a tie! Both players scored the same amount of points.");
        }
    }

    public static int rollTheDice(Random rnd) {
        return rnd.nextInt(6) + 1;
    }

    public static void printDice(int value) {
        switch (value) {
            case 1:
                System.out.println(" _ ");
                System.out.println("|     |");
                System.out.println("|  *  |");
                System.out.println("|_____|");
                break;
            case 2:
                System.out.println(" _ ");
                System.out.println("| *   |");
                System.out.println("|     |");
                System.out.println("|___* |");
                break;
            case 3:
                System.out.println(" _ ");
                System.out.println("| *   |");
                System.out.println("|  *  |");
                System.out.println("|___* |");
                break;
            case 4:
                System.out.println(" _ ");
                System.out.println("| * * |");
                System.out.println("|     |");
                System.out.println("|_*_*_|");
                break;
            case 5:
                System.out.println(" _ ");
                System.out.println("| * * |");
                System.out.println("|  *  |");
                System.out.println("|_*_*_|");
                break;
            case 6:
                System.out.println(" _ ");
                System.out.println("| * * |");
                System.out.println("| * * |");
                System.out.println("| * * |");
                System.out.println("|_*_*_|");
                break;
        }
    }
}
