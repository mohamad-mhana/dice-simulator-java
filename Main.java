import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean appCompleted = false;
        do {
            try {
                System.out.println("How many dice would you like to roll?");
                int numberOfDice = input.nextInt();
                if (numberOfDice <= 0) {
                    System.out.println("please enter a positive number");
                    continue;
                }
                appCompleted = true;
                String diceWord = numberOfDice == 1 ? "die" : "dice";
                System.out.println("About to roll " + numberOfDice + " " + diceWord);
                for (int i = 0; i < numberOfDice; i++) {
                    int rolledNumber = (random.nextInt(6) + 1);
                    System.out.println(display(rolledNumber) + "\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("This is not a valid number");
                input.next();
            }
        } while (!appCompleted);
        input.close();

    }

    static String display(int value) {
        return switch (value) {

            case 1 -> "---------\n|       |\n|   o   |\n|       |\n---------";
            case 2 -> "---------\n| o     |\n|       |\n|     o |\n---------";
            case 3 -> "---------\n| o     |\n|   o   |\n|     o |\n---------";
            case 4 -> "---------\n| o   o |\n|       |\n| o   o |\n---------";
            case 5 -> "---------\n| o   o |\n|   o   |\n| o   o |\n---------";
            case 6 -> "---------\n| o   o |\n| o   o |\n| o   o |\n---------";
            default -> "Not a valid die face";

        };
    }
}