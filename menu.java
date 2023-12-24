import java.util.Scanner;

/**
 * Write a description of class menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class menu
{

    public static void main(String[] args){
        System.out.println('\u000c');//clear all previous text
        // instance of menu class
        menu m = new menu();
        //runing Menu menthod   
        m.Menu();
    }

    public void Menu(){
        //declare variable 
        int userInput;
        boolean valid = false;
        //using do while loop which end when user input is 0
        do{
            //printing some line
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");    
            System.out.println("please select one of the options below");
            System.out.println("1. Start game");
            System.out.println("2. Load game");
            System.out.println("3. Help");
            System.out.println("0. Exit");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-"); 

            //taking user input and storing in a variable
            Scanner s = new Scanner(System.in);
            userInput = s.nextInt();

            //using switch statement 
            switch(userInput){
                case 1://when user enter 1 open readfrom file and write file and copy file method
                    playermenu g = new playermenu();
                    g.menuPlayer();
                    break;

                case 2://when user enter 2 open hacking method
                    loadAGame l = new loadAGame();
                    l.display();

                    break;

                case 3://when user enter 3 open detail method
                    help.readFromFile();
                    break;

                case 0://when user enter 0 print some line

                    System.out.println("Are you sure (Press y for yes! if no press anything)");
                    Scanner si = new Scanner(System.in);
                    String userInput1 = si.nextLine();
                    switch(userInput1){
                        case "y":
                            System.out.println("Ohh so you want to leave me :*( But wait what about hidden feature of this game. Have you found all of them ");
                            System.out.println("press y for yes or i will explore them later");
                            Scanner sc = new Scanner(System.in);
                            String userInput2 = sc.nextLine();
                            switch(userInput2){
                                case "y":
                                    System.out.println("'Goodbye'");
                                    System.out.println("Now go to gym :-)");
                                    valid = true;
                                    System.exit(0);
                                    break;
                            }

                    }
                    break;
                default:// if user print invalid input
                    System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!"); 
                    valid = false;
            }

        }while(!valid);
    }
}
