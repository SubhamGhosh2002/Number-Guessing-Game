import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int score = 0;
        int maxAttempts = 5; // Limiting the number of attempts per round
        boolean playAgain = true;
        
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfGuesses = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");
            
            while (!hasGuessedCorrectly && numberOfGuesses < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfGuesses++;
                
                if (userGuess < numberToGuess) {
                    if (numberToGuess - userGuess <= 10) {
                        System.out.println("Your guess is too low, but you're very close!");
                    } 
                    else {
                        System.out.println("Your guess is too low.");
                    }
                } else if (userGuess > numberToGuess) {
                    if (userGuess - numberToGuess <= 10) {
                        System.out.println("Your guess is too high, but you're very close!");
                    } 
                    else {
                        System.out.println("Your guess is too high.");
                    }
                } else {
                    hasGuessedCorrectly = true;
                    score++;
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + numberOfGuesses + " guesses.");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you couldn't guess the number. The correct number was: " + numberToGuess);
            }
            
            System.out.println("Your current score: " + score);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
