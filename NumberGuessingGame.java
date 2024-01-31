import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Define the secret number's upper and lower bounds 
        int lowerBound = 1;
        int upperBound = 100;       
        //Limiting the number of trials
        int maxTrials=15;
        int rounds=0;
        int totalScore=0;  

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("------------------------------------");
           do{ 
            // Initialize to track whether or not the user properly guessed.
            boolean CorrectGuess = false;
            rounds++; 
            // Obtain a random secret number within the limits that are mentioned.
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            // Initialize the number of guesses to 0
            int Trials = 0; 
            System.out.println("ROUND:"+rounds);
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);
        
        // Start a loop until the user guesses the correct number
        while (!CorrectGuess && Trials<=maxTrials) {
            System.out.print("Guess the number: ");
            int UserInput = input.nextInt();
            Trials++;  // Increment the number of guesses

            // Compare the user's guess with the generated number
            if (UserInput < secretNumber) {
                System.out.println("Too low! Try again.");
            } 
            else if (UserInput > secretNumber) {
                System.out.println("Too high! Try again.");
            } 
            else{
                // If the guess is correct, display a congratulations and the number of tries
                System.out.println("Congratulations! You've guessed the  secret number ("+secretNumber+") correctly");
                CorrectGuess = true;  // Set to true to exit the loop
            }
        }
        if(CorrectGuess){
            totalScore++;
            if (Trials <= 5) {
                System.out.println(" Exceptional! You guessed the number in "+ Trials +" tries.. Excellent job!");
            } else if (Trials <= 10) {
                System.out.println("Well done! You successfully guessed the number in "+ Trials +" tries. Nice effort!");
            } else {
                System.out.println("Good effort! You guessed the number, but with "+ Trials +" tries, there's room for improvement..");
            }
        }
        
        if(!CorrectGuess && Trials>maxTrials){
            System.out.println("You have reached maximum attempts!");
            System.out.println("The secret number was " + secretNumber+"\n GAME OVER");
        }
        
        System.out.println("Enter 'y' if you want to play another round");
    }
     
     while(input.next().equalsIgnoreCase("y"));
       
     System.out.println("Thanks for playing !");
     System.out.println("Total Score: "+totalScore);
     input.close();
     
    }
}
    