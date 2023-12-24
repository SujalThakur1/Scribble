import java.util.*;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class savedFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class savedFile
{
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }
                //printing score to file
                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile2(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame2.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile3(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame3.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile4(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame4.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile5(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame5.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    
    /*
     * method which take String from game class  and Check if word exist in dictionary or not and returning boolean
     */
    public boolean checkWord(String word){
        boolean b = false; 
        boolean bull = false;

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        // declare a String variable which will be used during the 
        // file processing steps below to store a line of text which
        // has been read in from a file
        String nextLine;

        // use a try-catch-finally block to catch file-related exceptions
        try
        {
            // create a new FileReader object and provide it with the path to the 
            // file you wish to read from. You can specify a full path or a relative
            // path. A relative path is used in this example which assumes that the
            // a file named 'lotteryNumbers.txt' exists and is located in the 
            // same folder as this BlueJ project. If it doesn't, an error will occur
            fileReader = new FileReader("wordList.txt");

            // create a new BufferedReader object and provide it with the FileReader
            // which will be used to write information to the underlying file
            bufferedReader = new BufferedReader(fileReader); 

            // attempt to read the first line of data in the file
            // if there was an error or no data to read (e.g. if the
            // file is empty or we have reached the end of the file)
            // the 'readLine()' method will return a value of 'null'
            // We can check for this value when processing the file
            // the contents (see the 'while' loop below)
            nextLine = bufferedReader.readLine();

            // while the next line of data is valid (e.g. isn't 'null')

            while (nextLine != null)
            {

                
                if (nextLine.equals(word)){
                    b = true;
                    return b;
                }
                else{
                    b = false;
                }

                // attempt to read another line from the file
                nextLine = bufferedReader.readLine();
            } 
        }
        catch (FileNotFoundException e)
        {
            // an exception has occurred during the processing of the statements in the 'try'
            // section, e.g. failed to open or read from the file

            // display a message to the user to inform them of the error
            System.out.println("Sorry, your file was not found.");
        }
        catch (IOException e)
        {
            // an exception has occurred during the processing of the statements in the 'try'
            // section, e.g. failed to open or read from the file

            // display a message to the user to inform them of the error
            System.out.println("Sorry, there has been a problem opening or reading from the file");
        }
        finally
        {
            // if the file was opened
            if (bufferedReader != null)
            {
                try 
                {
                    // try to close it
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    // warn user file wasn't properly closed
                    System.out.println("Sorry, there has been a problem closing the file");
                }
            }
        }

       
        return b;
    }

    /*
     * method which take String from four player class  and print that into a file
     */
    public static void writeFile6(char[][] board , int mark, int mark2, int mark3 ,int mark4) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame6.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}"  +mark3 + "}"+ mark4);

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from four player class  and print that into a file
     */
    public static void writeFile7(char[][] board , int mark, int mark2, int mark3 ,int mark4) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame7.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" +mark3 + "}"+ mark4 );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from four player class  and print that into a file
     */
    public static void writeFile8(char[][] board , int mark, int mark2, int mark3 ,int mark4) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame8.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" +mark3 + "}"+ mark4 );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from four player class  and print that into a file
     */
    public static void writeFile9(char[][] board , int mark, int mark2, int mark3 ,int mark4) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame9.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" +mark3 + "}"+ mark4 );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from four player class  and print that into a file
     */
    public static void writeFile10(char[][] board , int mark, int mark2, int mark3 ,int mark4) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame10.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" +mark3 + "}"+ mark4 );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile11(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame11.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile12(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame12.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile13(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame13.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile14(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame14.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    /*
     * method which take String from game class  and print that into a file
     */
    public static void writeFile15(char[][] board , int mark, int mark2) {

        //creating fileOutputStream instance and initialize value null

        
        FileOutputStream outputStream = null;
        //creating fileOutputStream instance and initialize value null
        PrintWriter printWriter = null;
        //creating boolean valid variable to end loop
        boolean valid = false;
        //printing design
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //printing some text
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        //taking user input and storing in String variable

        char[][] myString = board;
        //using try catch finally method for wrinting a line one at a time     
        try
        {
            // creating variable and that write text in a file    
            outputStream = new FileOutputStream("saveGame15.txt");
            printWriter = new PrintWriter(outputStream);
            //using loop that end when boolean is true
            do{
                //printing userinput in file

                //read for next input
                //using if statement when line is empty boolean is true

                for (int i=0; i<myString.length; i++)
                {
                    for(int j = 0 ; j<myString.length; j++){
                        //printing to file

                        printWriter.print(myString[j][i] );

                    }
                    printWriter.print("}");
                }

                printWriter.print(mark + "}" + mark2 + "}" );

                valid = true;
            }while(!valid);
        }
        catch (IOException e)
        {
            //printing if there is a error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            //using if statement to close file when string is empty
            if (printWriter != null){
                printWriter.close();
            }  
        }

              
            
    }
    
}
