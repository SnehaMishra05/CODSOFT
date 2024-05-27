package CODSOFT;

import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    static final int MAX_ATTEMPTS = 10;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;
        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess < number)
                    System.out.println("Too low! Try Again");
                else if (userGuess > number)
                    System.out.println("Too high! Again");
                else {
                    System.out.println("Correct! You've guessed the number!");
                    hasGuessedCorrectly = true;
                    score++;
                }
                if (attempts == MAX_ATTEMPTS && !hasGuessedCorrectly) {
                    System.out.println(
                            "Sorry, you've reached the maximum number of attempts.\nThe number was: " + number);
                }
            }
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.next().equalsIgnoreCase("yes");
        } while (playAgain);
        System.out.println("Your total score: " + score);
        System.out.println("Thank You for playing!");
        sc.close();
    }
}