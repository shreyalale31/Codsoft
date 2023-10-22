import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Game!");

        while (playAgain) {
            int lowerLimit = 1;
            int upperLimit = 100;
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int maxAttempts = 5;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerLimit + " and " + upperLimit + ".");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number: ");
                int userGuess = scanner.nextInt();

                if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in  "
                            + (attempts + 1) + " attempts.");
                    roundsWon++;
                    break;
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was "
                        + secretNumber + ".");
            }

            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("You played " + roundsPlayed + " rounds and won " + roundsWon + " rounds.");
        System.out.println("Thanks for playing!");
    }
}
