import java.io.*;//importing java file
import java.util.Scanner;//importing java scanner to take input

/**
 * Write a description of class loadAGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class loadAGame  
{
    /*
     * method which display menu of 2 player saved game or 4 player saved game
     */
    public void display(){
        System.out.println("Chooes file");
        System.out.println("Press 1 => Duo saved game");
        System.out.println("Press 2 => Squad");
        System.out.println("Press 3 => solo");

        boolean valid = false;
        do{
            Scanner s = new Scanner(System.in);
            int userInput = s.nextInt();
            switch(userInput){
                case 1:
                    readFromFile();
                    valid = true;
                    break;
                case 2:
                    readFromFile2();
                    valid = true;
                    break;
                case 3:
                    readFromFile3();
                    break;
                default:
                    valid = false;
                    System.out.println("Invalid input");
            }
        }while(!valid);
    }

    /*
     * method which read from a file and send line to game method
     */
    public void readFromFile() {  
        //creating FileReader instance and initialize value null
        FileReader fileReader = null;
        //creating FileReader instance and initialize value null
        BufferedReader bufferedReader = null;
        boolean valid = false;
        // printing some text
        System.out.println("Choose your saved game");
        System.out.println("Press.1 => Game1");
        System.out.println("Press.2 => Game2");
        System.out.println("Press.3 => Game3");
        System.out.println("Press.4 => Game4");
        System.out.println("Press.5 => Game5");
        //storing value of user input in filename variable
        File file = new File("saveGame.txt");
        File file2 = new File("saveGame2.txt");
        File file3 = new File("saveGame3.txt");
        File file4 = new File("saveGame4.txt");
        File file5 = new File("saveGame5.txt");

        do{
            Scanner s = new Scanner(System.in);
            int fileName = s.nextInt();

            switch(fileName){
                case 1:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    game g = new game();
                                    g.loadGame(nextLine);

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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

        
                    valid = true;
                    break;

                case 2:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file2.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame2.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    game g = new game();
                                    g.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 3:

                    if (file3.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame3.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    game g = new game();
                                    g.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 4:

                    if (file4.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame4.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    game g = new game();
                                    g.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 5:
                    if (file5.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame5.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    game g = new game();
                                    g.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                default:
                    valid = false;
                    System.out.println("Please enter valid input");
            }
        }while(!valid);

        //printing empty line 
        System.out.println("");
    }

    /*
     * method which read from a file and send line to fourplayer method
     */
    public void readFromFile2() {  
        //creating FileReader instance and initialize value null
        FileReader fileReader = null;
        //creating FileReader instance and initialize value null
        BufferedReader bufferedReader = null;
        boolean valid = false;
        // printing some text
        System.out.println("Choose your saved game");
        System.out.println("Press.1 => Game1");
        System.out.println("Press.2 => Game2");
        System.out.println("Press.3 => Game3");
        System.out.println("Press.4 => Game4");
        System.out.println("Press.5 => Game5");
        //storing value of user input in filename variable
        File file = new File("saveGame6.txt");
        File file2 = new File("saveGame7.txt");
        File file3 = new File("saveGame8.txt");
        File file4 = new File("saveGame9.txt");
        File file5 = new File("saveGame10.txt");

        do{
            Scanner s = new Scanner(System.in);
            int fileName = s.nextInt();

            switch(fileName){
                case 1:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame6.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    fourPlayer p = new fourPlayer();
                                    p.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("Sorry sir but you can only load a game that you have saved");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

        
                    valid = true;
                    break;

                case 2:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file2.length() != 0)
                    {   

                        try
                        {
                            //reading a file
                            fileReader = new FileReader("saveGame7.txt");
                            bufferedReader = new BufferedReader(fileReader);
                            //storing a file line in one variable
                            String nextLine = bufferedReader.readLine();
                            //using while to read all the line of the file and end when there is no file
                            while (nextLine != null )
                            {
                                //printing line of file

                                //reading next line

                                fourPlayer p = new fourPlayer();
                                p.loadGame(nextLine);

                                nextLine = bufferedReader.readLine();

                            }
                        }
                        catch (FileNotFoundException e)
                        {
                            //printing if there is a file not found error
                            System.out.println("save a game to access me");
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

                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 3:

                    if (file3.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame8.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    fourPlayer p = new fourPlayer();
                                    p.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 4:

                    if (file4.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame9.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    fourPlayer p = new fourPlayer();
                                    p.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 5:
                    if (file5.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame10.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    fourPlayer p = new fourPlayer();
                                    p.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                default:
                    valid = false;
                    System.out.println("Please enter valid input");
            }
        }while(!valid);

        //printing empty line 
        System.out.println("");
    }

    /*
     * method which read from a file and send line to solo method
     */
    public void readFromFile3() {  
        //creating FileReader instance and initialize value null
        FileReader fileReader = null;
        //creating FileReader instance and initialize value null
        BufferedReader bufferedReader = null;
        boolean valid = false;
        // printing some text
        System.out.println("Choose your saved game");
        System.out.println("Press.1 => Game1");
        System.out.println("Press.2 => Game2");
        System.out.println("Press.3 => Game3");
        System.out.println("Press.4 => Game4");
        System.out.println("Press.5 => Game5");
        //storing value of user input in filename variable
        File file = new File("saveGame11.txt");
        File file2 = new File("saveGame12.txt");
        File file3 = new File("saveGame13.txt");
        File file4 = new File("saveGame14.txt");
        File file5 = new File("saveGame15.txt");

        do{
            Scanner s = new Scanner(System.in);
            int fileName = s.nextInt();

            switch(fileName){
                case 1:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame11.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    solo sol = new solo();
                                    sol.loadGame(nextLine);

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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

        
                    valid = true;
                    break;

                case 2:

                    //declaring boolean
                    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
                    if (file2.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame12.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    solo sol = new solo();
                                    sol.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 3:

                    if (file3.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame13.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    solo sol = new solo();
                                    sol.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 4:

                    if (file4.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame14.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    solo sol = new solo();
                                    sol.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                case 5:
                    if (file5.length() != 0)
                    {   
                        if (file.canRead())
                        { 
                            try
                            {
                                //reading a file
                                fileReader = new FileReader("saveGame15.txt");
                                bufferedReader = new BufferedReader(fileReader);
                                //storing a file line in one variable
                                String nextLine = bufferedReader.readLine();
                                //using while to read all the line of the file and end when there is no file
                                while (nextLine != null )
                                {
                                    //printing line of file

                                    //reading next line

                                    solo sol = new solo();
                                    sol.loadGame(nextLine);

                                    nextLine = bufferedReader.readLine();

                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                //printing if there is a file not found error
                                System.out.println("save a game to access me");
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
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry sir but you can only load a game that you have saved");
                        return;
                    } 

                    valid = true;
                    break;
                default:
                    valid = false;
                    System.out.println("Please enter valid input");
            }
        }while(!valid);

        //printing empty line 
        System.out.println("");
    }

}
