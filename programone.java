import java.util.Random;
import java.util.Scanner;

public class programone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int Max_try = 10;
        System.out.println("Welcome to the the \" Number-Guess \"  game.");
        System.out.println("Guess the number between " + 1 + " to " + 100);
        boolean play = true;
        do {
            int secretNumber = random.nextInt(100) + 1;
            int tried = 0;
            int gs;

            while (true) {
                if (tried == Max_try) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                            + secretNumber);
                    break;
                } else {

                    System.out.print("Enter your guess: ");
                    gs = sc.nextInt();
                    tried++;

                    if (gs == secretNumber) {
                        System.out
                                .println("Congratulations! You guessed the correct number in " + tried + " attempts.");
                        System.out.printf("Your Score is : %d. \n \n ", (1000 - tried * 100));
                        break;
                    } else if (gs < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }

                }
            }

            // rounds++;

            System.out.print("Do you want to play another round? (Y/N): ");
            String playAgain = sc.next();

            if (playAgain.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                System.out.println("Ending the Game.\n");
                break;
            }
        } while (play);
        sc.close();

    }
}
