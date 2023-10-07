import java.util.*;
import java.util.Random;
class Number_gguessing_game
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String play="yes";
        while(play.equals("yes"))
        {
            Random rand=new Random();
            int randnum=rand.nextInt(100);
            int guess=-1;
            int tries=0;
            while(guess!=randnum)
            {
                System.out.println("Guess a number between 1 and 100");
                guess=sc.nextInt();
                tries++;
                if(guess==randnum)
                {
                    System.out.println("HURRAY! YOU WIN");
                    if(guess==5)
                        System.out.println("Total no of Try is:  " +tries+"  :which is a awsome play");
                    else
                         System.out.println("Total no of try is:  " +tries+" :its ok but it can be better");
                    System.out.println("would you like to play again?Yes or No");
                    play=sc.next().toLowerCase();
                }
                else if(guess>randnum)
                {
                    System.out.println("Your guess is too High,Try again");
                }
                else
                {
                    System.out.println("your guess is too low,Try again");
                }
                
            }
        }
        sc.close();
    }
}