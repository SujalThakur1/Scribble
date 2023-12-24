import java.util.Scanner;

/**
 * Write a description of class playermenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class playermenu
{
    public void menuPlayer(){
        //declare variable 
        int userInput;
        boolean valid = false;
        //using do while loop which end when user input is 0
        do{
            //printing some line
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");    
            System.out.println("please select one of the options below");
            System.out.println("1. Solo");
            System.out.println("2. Duo");
            System.out.println("3. Squad");

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");    
            //taking user input and storing in a variable
            Scanner s = new Scanner(System.in);
            userInput = s.nextInt();
            //using switch statement 
            switch(userInput){
                case 1://when user enter 1 calling method from solo class 
                    solo sol = new solo();
                    sol.displayEverything();
                    valid = true;
                    break;

                case 2://when user enter 2 calling method from game class 
                    game g = new game();
                    g.displayEverything();
                    valid = true;
                    break;

                case 3://when user enter 3 calling method from fourplayer class
                    fourPlayer f = new fourPlayer();
                    f.gamePlay();
                    valid = true;
                    break;

                             
                default:// if user print invalid input
                    System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!"); 
                    valid = false;
            }

        }while(!valid);
    }
}
