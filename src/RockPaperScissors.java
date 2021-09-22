import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        // Set game mode - prompt user for game mode
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        System.out.println("#############################################################");
        System.out.println("           Welcome to the Rock Paper Scissors game           ");
        System.out.println("#############################################################");
        System.out.println("ROCK:              PAPER:                  SCISSORS:");
        System.out.println("    _______            _______                 _______");
        System.out.println("---'   ____)       ---'   ____)____        ---'   ____)____");
        System.out.println("      (_____)                ______)                 ______)");
        System.out.println("      (_____)                _______)             __________)");
        System.out.println("      (____)                _______)             (____)");
        System.out.println("---.__(___)        ---.__________)         ---.__(___)");
        System.out.println("'''                '''                     '''");

        // Set game mode
        int mode;
        // Continue play
        String play = "y";
        while(play.equals("y")){
            System.out.println("Select 1 for single player and 2 for multiplayer:");
            mode = scannerInt.nextInt();
            if(mode==1){
                final String computerName = "Computer";
                System.out.println("Enter your name:");
                String playerOneName = scannerString.nextLine();

                String playerOneChoice = getChoice(playerOneName);
                String computerChoice = getComputerChoice();

                gameResult(playerOneName,playerOneChoice,computerName,computerChoice);
            }else if(mode==2){
                System.out.println("Player1: Enter your name:");
                String playerOneName = scannerString.nextLine();
                System.out.println("Player2: Enter your name:");
                String playerTwoName = scannerString.nextLine();

                String playerOneChoice = getChoice(playerOneName);
                // Create spacing, so player 2 can't see what player 1 entered!
                for (int i=0; i<10; i++){
                    System.out.println(" ");
                }
                String playerTwoChoice = getChoice(playerTwoName);

                gameResult(playerOneName,playerOneChoice,playerTwoName,playerTwoChoice);
            }else{
                System.out.println("Invalid mode selected!!!");
            }
            System.out.println("Do you want to play again? (y/n)");
            play = scannerString.nextLine();
        }
        System.out.println("Thanks for playing :)");
    }

    public static String getChoice(String playerName){
        Scanner scannerString = new Scanner(System.in);
        boolean validChoice = false;
        String playerChoice = null;
        while(!validChoice){
            System.out.println(playerName+": Choose between - ROCK (r), PAPER (p) or SCISSORS (s):");
            playerChoice = scannerString.nextLine();
            if(playerChoice.equals("r")){
                playerChoice = "ROCK";
                validChoice = true;
            }else if(playerChoice.equals("p")){
                playerChoice = "PAPER";
                validChoice = true;
            }else if(playerChoice.equals("s")){
                playerChoice = "SCISSORS";
                validChoice = true;
            }else{
                System.out.println("Wrong choice! Try again:");
            }
        }
        return playerChoice;
    }

    public static String getComputerChoice(){
        Random random = new Random();
        String computerChoice;
        int randomNumber = random.nextInt(3)+1;
        if(randomNumber==1){
            computerChoice = "ROCK";
        }else if (randomNumber==2){
            computerChoice = "PAPER";
        }else{
            computerChoice = "SCISSORS";
        }
        return computerChoice;
    }

    public static void gameResult(String playerOneName,String playerOneChoice,
                                 String playerTwoName,String playerTwoChoice){
        System.out.println(playerOneName+" selected "+playerOneChoice+" and "+
                playerTwoName+" selected "+playerTwoChoice+":");
        if(playerOneChoice.equals(playerTwoChoice)){
            System.out.println("DRAW!!!");
        }else if (playerOneChoice.equals("ROCK") && playerTwoChoice.equals("SCISSORS")){
            System.out.println(playerOneName+" wins!!!");
        }else if (playerOneChoice.equals("ROCK") && playerTwoChoice.equals("PAPER")){
            System.out.println(playerTwoName+" wins!!!");
        }else if (playerOneChoice.equals("SCISSORS") && playerTwoChoice.equals("PAPER")){
            System.out.println(playerOneName+" wins!!!");
        }else if (playerOneChoice.equals("SCISSORS") && playerTwoChoice.equals("ROCK")){
            System.out.println(playerTwoName+" wins!!!");
        }else if (playerOneChoice.equals("PAPER") && playerTwoChoice.equals("ROCK")){
            System.out.println(playerOneName+" wins!!!");
        }else if (playerOneChoice.equals("PAPER") && playerTwoChoice.equals("SCISSORS")){
            System.out.println(playerTwoName+" wins!!!");
        }
    }

}
