package Double_Six_Game;
import java.util.Scanner;
public class Task_2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String player = "P1";
        int p1_Rolls = 0;
        int p2_Rolls = 0;

        while(true) // while loop for the game to run
        {
            System.out.println("It's your turn " + player + "\nWhat is the number?");
            int number = input.nextInt();

            if(player.equals("P1")) // Roll count tracker
            {
                p1_Rolls++;
            }
            else
            {
                p2_Rolls++;
            }

            if(player.equals("P2") && number == 6) // Game ender code
            {
                break;
            }
            else if(number == 6)
            {
                player = "P2";
            }
        }
        System.out.println("------------");
        if(p1_Rolls == p2_Rolls) // Outcome interpreter
        {
            System.out.println("The game is a draw!");
        }
        else if(p1_Rolls < p2_Rolls)
        {
            System.out.println("Player 1 wins!");
        }
        else
        {
            System.out.println("Player 2 wins!");
        }
        System.out.println("------------");
    }
}