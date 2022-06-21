import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner userInput = new Scanner(System.in);
        int guessNumber = rand.nextInt(20)+1;
        String userName;
        String userContinue = "y";
        int userNumber;
        int guesses = 1;
        System.out.println("\nHello! What is your name?\n");
        userName = userInput.nextLine();

        System.out.println("Well " + userName + ", I am thinking of a number between 1 and 20.\n");

        do {
            System.out.println("\nTake a guess!\n");
            userNumber = userInput.nextInt();
            if (userNumber==guessNumber){
                System.out.println("Good job "+userName+"!, You guessed my number in " + guesses +" guesses!\n");
                System.out.println("Would you like to play again? (y or n)\n");
                userContinue = userInput.next();
                if (userContinue.equalsIgnoreCase("y")){
                    guesses = 0;
                    guessNumber = rand.nextInt(20)+1;
                    System.out.println("Well " + userName + ", I am thinking of a number between 1 and 20.\n");
                }
            } else if (userNumber>guessNumber){
                System.out.println("Your guess is too high! Take a guess!\n");
            }else if (userNumber<guessNumber){
                System.out.println("Your guess is too low! Take a guess!\n");
            }
            guesses++;
        }while(guesses<=6&&!userContinue.equalsIgnoreCase("n"));

        if (guesses>6){
            System.out.println("You almost had it!\n");
            System.out.println("Better luck next time!\n");
        }

    }
}
