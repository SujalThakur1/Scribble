import java.io.*;
import java.util.Scanner;

/**
 * Write a description of class help here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class help
{
    /*
     * creating a read Form File method which will read a text from file and 
     * display them on a screen also method will read that file which user
     * want to. So user have to give a name of file 
     */
    public static void readFromFile() {  
        //creating FileReader instance and initialize value null
        FileReader fileReader = null;
        //creating FileReader instance and initialize value null
        BufferedReader bufferedReader = null;

        // printing some text
        int userInput;
        do{
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");
            System.out.println("Press 1 - GamePlay");
            System.out.println("Press 2 - Scoring");
            System.out.println("press 3 - Setup");
            System.out.println("press 0 - Back");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");
            Scanner s = new Scanner(System.in);
            userInput = s.nextInt(); 
            switch (userInput){
                case 1:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("G A M E   P l a y");
                    System.out.println("------------------------------------------------------------------------------");
                    //using try catch finally method for reading lines from text file
                    try
                    {
                        //reading a file
                        fileReader = new FileReader("Game PLay.txt");
                        bufferedReader = new BufferedReader(fileReader);
                        //storing a file line in one variable
                        String nextLine = bufferedReader.readLine();
                        //using while to read all the line of the file and end when there is no file
                        while (nextLine != null )
                        {
                            //printing line of file

                            System.out.println(nextLine);
                            //reading next line
                            nextLine = bufferedReader.readLine();
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        //printing if there is a file not found error
                        System.out.println("file was not found");
                    }
                    catch (IOException e)
                    {
                        //printing if there is a exception error
                        System.out.println("IO Error reading from file: " + e);
                    }
                    finally
                    {
                        //using if statment for closing file when file line is null
                        if (bufferedReader != null){
                            //using try catch for error handling
                            try{
                                bufferedReader.close();
                            }
                            catch (IOException e)
                            {
                                //warining 
                            }
                        }   

                    }
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(" S C O R I N G ");
                    System.out.println("------------------------------------------------------------------------------");

                    //using try catch finally method for reading lines from text file
                    try
                    {
                        //reading a file
                        fileReader = new FileReader("Scoring.txt");
                        bufferedReader = new BufferedReader(fileReader);
                        //storing a file line in one variable
                        String nextLine = bufferedReader.readLine();
                        //using while to read all the line of the file and end when there is no file
                        while (nextLine != null )
                        {
                            //printing line of file
                            System.out.println(nextLine);
                            //reading next line
                            nextLine = bufferedReader.readLine();
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        //printing if there is a file not found error
                        System.out.println("file was not found");
                    }
                    catch (IOException e)
                    {
                        //printing if there is a exception error
                        System.out.println("IO Error reading from file: " + e);
                    }
                    finally{
                        //using if statment for closing file when file line is null
                        if (bufferedReader != null){
                            //using try catch for error handling
                            try{
                                bufferedReader.close();
                            }
                            catch (IOException e)
                            {
                                //warining 
                            }
                        }    
                    }
                    break;

                case 3:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("S E T--U P");
                    System.out.println("------------------------------------------------------------------------------");
                    //using try catch finally method for reading lines from text file
                    try
                    {
                        //reading a file
                        fileReader = new FileReader("setup.txt");
                        bufferedReader = new BufferedReader(fileReader);
                        //storing a file line in one variable
                        String nextLine = bufferedReader.readLine();
                        //using while to read all the line of the file and end when there is no file
                        while (nextLine != null )
                        {
                            //printing line of file
                            System.out.println(nextLine);
                            //reading next line
                            nextLine = bufferedReader.readLine();
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        //printing if there is a file not found error
                        System.out.println("file was not found");
                    }
                    catch (IOException e)
                    {
                        //printing if there is a exception error
                        System.out.println("IO Error reading from file: " + e);
                    }
                    finally{
                        //using if statment for closing file when file line is null
                        if (bufferedReader != null){
                            //using try catch for error handling
                            try{
                                bufferedReader.close();
                            }
                            catch (IOException e)
                            {
                                //warining 
                            }
                        }    
                    }
                    break;
                case 0://when user enter 0 print some line
                    break;

                default:// if user print invalid input
                    if(userInput != 0){
                        System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!"); 
                    }

            }
        }while(userInput != 0);

        //printing empty line 
        System.out.println("");
    }
}
