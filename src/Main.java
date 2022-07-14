import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean checkInput(String userNumber){
        return !userNumber.equals("20")
                &&!userNumber.equals("1")
                &&!userNumber.equals("2")
                &&!userNumber.equals("3")
                &&!userNumber.equals("4")
                &&!userNumber.equals("5")
                &&!userNumber.equals("6")
                &&!userNumber.equals("7")
                &&!userNumber.equals("8")
                &&!userNumber.equals("9")
                &&!userNumber.equals("10")
                &&!userNumber.equals("11")
                &&!userNumber.equals("12")
                &&!userNumber.equals("13")
                &&!userNumber.equals("14")
                &&!userNumber.equals("15")
                &&!userNumber.equals("16")
                &&!userNumber.equals("17")
                &&!userNumber.equals("18")
                &&!userNumber.equals("19");
    }
    public static String getUserName(){
        String userName;
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nHello! What is your name?\n");
        userName = userInput.nextLine();
        return userName;

    }
    public static String getUserContinue(){
        System.out.println("Would you like to play again? (y or n)\n");
        Scanner userInput = new Scanner(System.in);
        String userContinue = userInput.nextLine();
        while(userContinue.equalsIgnoreCase("y")&&userContinue.equalsIgnoreCase("n")){
            System.out.println("(y or n)\n");
            userContinue = userInput.nextLine();
        }
        return userContinue;
    }

    public static int getNumber(){
        Scanner userInput = new Scanner(System.in);
        String userNumber;
        int number;

        System.out.println("\nTake a guess!\n");
        userNumber = userInput.nextLine();
        while(checkInput(userNumber)){
            System.out.println("\nNeeds to be a number between 1-20, take another guess!\n");
            userNumber=userInput.nextLine();
        }
        number = Integer.parseInt(userNumber);
        return number;

    }
    public static void dialog(){
        Random rand = new Random();
        int guessNumber = rand.nextInt(20)+1;
        int userNumber;
        int guesses = 1;
        String userName = getUserName();
        String userContinue = "y";

        System.out.println("Well " + userName + ", I am thinking of a number between 1 and 20.\n");
        do {
            userNumber = getNumber();
            if (userNumber == guessNumber){
                System.out.println("Good job "+userName+"!, You guessed my number in " + guesses +" guesses!\n");
                userContinue = getUserContinue();
                if (userContinue.equalsIgnoreCase("y")){
                    guesses = 0;
                    guessNumber = rand.nextInt(20)+1;
                    System.out.println("Well " + userName + ", I am thinking of a number between 1 and 20.\n");
                }
            } else if (userNumber>guessNumber){
                System.out.println("Your guess is too high! Take a guess!\n");
            }else {
                System.out.println("Your guess is too low! Take a guess!\n");
            }
            guesses++;
        }while(guesses<=6&&!userContinue.equalsIgnoreCase("n"));

        if (guesses>6){
            System.out.println("You almost had it!\n");
            System.out.println("Better luck next time!\n");
        }else{
            System.out.println("Thanks for playing!");
        }
    }
    public static void main(String[] args){
        dialog();
    }
}
