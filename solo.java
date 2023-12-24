import java.util.*;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class solo
{
    //declaring variable
    private char[][] board = new char [15][15];
    private int score;
    private int score2;
    private int row;
    private int column;
    private boolean valid;
    private int bonus;
    private int bonus8;
    private int bonus2;
    private int bonus3;
    private int bonus4;
    private int bonus5;
    private int bonus6;
    private int bonus7;
    private boolean realBonus;
    private boolean hiddenBonus;
    private boolean attach;
    // constructor
    public solo(){
        //initialising board value
        for (int i = 0; i<board.length;i++){
            for (int j = 0; j<board.length;j++){
                board[i][j] = ' ';
            }
        }
        board[1][1] = '*' ;
        board[1][11] = '*' ;
        board[12][13] = '*' ;
        board[10][12] = '*' ;
        board[4][3] = '*' ;
        board[13][3] = '*' ;
        //initialising bonus and score and some boolean value
        realBonus = false;
        bonus = 0;
        bonus6 = 0;
        bonus2 = 0;
        bonus3 = 0;
        bonus4 = 0;
        bonus5 = 0;
        bonus7 = 0;
        bonus8 = 0;
        int row = 0;
        int column = 0;
        hiddenBonus = false;
        valid = false;
        attach = false;
        score = 0;
        score2 = 0;

    }
    // creating a display method to display board
    public void Display(){
        int p = 1;
        System.out.println("    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
        System.out.println("  |---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|");
        for (int i = 0; i<board.length;i++){

            if(i > 8){
                System.out.print(p++  + "|");
            }
            else{
                System.out.print(p++ +" "+ "|");
            }
            for (int j = 0; j<board.length;j++){
                System.out.print( " "+board[j][i]+" |");

            }
            System.out.println("\n" +"  |___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|");
        }

    }
    //creating a display everyting method for player turn one after another and end when score is 100 or more than 100
    public void displayEverything(){

        valid = false;//variable
        boolean validss = false;//variable

        //loop for player trun one after another
        do{
            String var = player();//taking String from player and storing in var variable
            // if statment or a string to end loop and save game or quit
            if (var.equals("b")){
                valid = true;
            }

            else{
                //if statement to check word position is linked to another word or not 
                if(attach){

                    int bon = var.length();
                    if (realBonus){
                        System.out.println("Player 1 gets " + bon + " point bonus");
                    }
                    else if(hiddenBonus){
                        System.out.println("Congrats player 1 you have found the hidden bonus");
                    }
                    else{
                        //
                    }
                    score(var);
                    score = score + score(var);

                }
                else if(var.equals("0")){
                    //String 0 for pass turn
                }
                else if(!attach){//repeat again if false
                    validss = false;
                    while(!validss){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        var = player();
                        if(attach){
                            validss = true;
                        }
                        else if(var.equals("0")){
                            validss = true;
                        }
                        else{
                            validss = false;
                        }
                    }
                }else{
                    //
                }

                if(var.equals("0")){
                    // for passing trun
                }else{
                    Display();// displaying board
                }
                score(var);//sending var variable in score method to check score
                int bon = var.length();// creating bon variable and initialling to word length
                //if statment to check if there is a bonus or not
                if (realBonus){
                    System.out.println("Player 1 gets " + bon + " point bonus");
                }
                else if(hiddenBonus){
                    System.out.println("Congrats player 1 you have found the hidden bonus");
                }
                else{
                    //
                }
                validss = false;//variable
                //while loop for 2nd player
                while(!validss){
                    String var2 = player2();
                    //bonus check
                    if(attach){

                        validss = true;
                        int bon2 = var2.length();
                        if (realBonus){
                            System.out.println("Player 2 gets " + bon2 + " point bonus");
                        }
                        else if(hiddenBonus){
                            System.out.println("Congrats player 2 you have found the hidden bonus");
                        }
                        else{
                            //
                        }
                        score(var2);
                        score2 = score2 + score(var2);

                    }
                    // check if string is 0 then pass trun
                    else if(var2.equals("0")){
                        validss = true;
                    }
                    else if(!attach){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        valid = false;
                    }

                }
                Display();//display 
                //printing score
                valid = false;
                System.out.println("Player1 score is - " + score);
                System.out.println("Player2 score is - " + score2);
                // ending loop when score is 100 or more than 100
                if(score<=99 && score2<=99){
                    System.out.println("press b => Back");
                }
                else{
                    //
                }
                if(score > score2 && score >= 100){
                    System.out.println("player 1 wins");
                    valid = true;
                }
                else if (score2 > score && score2 >= 100){
                    System.out.println("player 2 wins");
                    valid = true;
                }
                else if (score >= 100 && score2>=100){
                    if(score < score2){
                        System.out.println("player 2 wins");
                        valid = true;
                    }
                    else if (score>score2){
                        System.out.println("player 1 wins");
                        valid = true;
                    }
                    else if (score==score2){
                        System.out.println("Its a tie");
                        System.out.println("Are you satisfied");
                        System.out.println("Press 1 if you are not satisfied with result");
                        System.out.println("Press 2 if you are are satisfied with result");
                        boolean valids = false;
                        //check if score is equal and player are satisfied or not if not than one more turn
                        do{
                            Scanner s = new Scanner(System.in);
                            int userInput = s.nextInt();
                            switch(userInput){
                                case 1:
                                    valid = false;
                                    valids = true;
                                    break;
                                case 2:
                                    valids = true;
                                    valid = true;
                                    break;
                                default:
                                    System.out.println("please enter valid key!!");
                                    valid = false;
                            }
                        }while(!valids);
                    }
                }

            }

        }while(!valid);
    }

    /*
     * player 1 method for 1st player
     */
    public String player(){
        System.out.println("PLAYER 1 TURN");
        hiddenBonus = false;//initiziling variable
        realBonus = false;
        attach = false;
        savedFile save = new savedFile();
        String word = "" ;

        if(score != 0){
            System.out.println("Press 0 to pass the turn");
        }
        else{
            //
        }
        System.out.println("choose word between 2 to 7 words");
        Scanner s = new Scanner(System.in);
        word = s.nextLine();
        // if word is b then calling back method
        if(word.equals("b"))
        {
            back();

        }
        else{
            if(word.equals("0"))//passing trun
            {
                //
            }else
            {
                //checking word length 
                if(word.length() >=2 && word.length() <= 7)
                {
                    valid = save.checkWord(word);// cheacking word in dictionary and getting boolean
                    if(valid)
                    {
                        //
                    }
                    else
                    {
                        System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                        do
                        {
                            Scanner si = new Scanner(System.in);//same thing again if word is not in dictionary 
                            word = si.nextLine();
                            valid = save.checkWord(word);
                            if(word.length() >=2 && word.length() <= 7 && valid)
                            {
                                valid = true;
                            }
                            else
                            {
                                System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                                valid = false;
                            }
                        }while(!valid);
                    }
                }
                else
                {
                    System.out.println("enter valid input");
                    do{
                        Scanner si = new Scanner(System.in);
                        word = si.nextLine();
                        valid = save.checkWord(word);
                        if(word.length() >=2 && word.length() <= 7 && valid)
                        {
                            valid = true;
                        }
                        else
                        {
                            System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                            valid = false;
                        }
                    }while(!valid);
                }
                //checking score if 0 than printing 1st word on center of board
                if(score == 0)
                {
                    System.out.println("press 1 for horizontal");
                    System.out.println("press 2 for vartical");
                    do{
                        Scanner s2 = new Scanner(System.in);
                        int place = s2.nextInt();
                        //checking for horizontal and vertical
                        switch(place){
                            case 1:
                                for(int i = 0 ; i<word.length(); i++){
                                    char p = word.charAt(i);
                                    board[7 - 1][7 + i -1] = p;
                                    attach = true;
                                }
                                valid = true;
                                break;

                            case 2:
                                for(int j = 0 ; j<word.length(); j++){
                                    char w = word.charAt(j);
                                    board[7 + j -1][7 - 1] = w;
                                    attach = true;
                                }
                                valid = true;
                                break;
                            default:// if user print invalid input
                                System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!");
                                valid = false;

                        }

                    }while(!valid);
                }else if(score != 0)//if score is more than 0 than placing word to attach to another word
                {
                    System.out.println("choose row");
                    int row;
                    //loop to check row length
                    do{

                        Scanner si = new Scanner(System.in);
                        row = si.nextInt();
                        if (row >= 1 && row <= 15){
                            valid = true;
                        }
                        else{
                            System.out.println("enter valid input");
                            valid = false;
                        }
                    }while(!valid);
                    System.out.println("choose column");
                    int column = 0;
                    //loop to check column length
                    do{

                        Scanner sj = new Scanner(System.in);
                        column = sj.nextInt();
                        if (column >= 1 && column <= 15){
                            valid = true;
                        }
                        else{
                            System.out.println("enter valid input");
                            valid = false;
                        }
                    }while(!valid);

                    System.out.println("press 1 for vertical");
                    System.out.println("press 2 for horizontal");

                    do{
                        Scanner s2 = new Scanner(System.in);
                        int place = s2.nextInt();
                        //switch for checking horizontal or vertical
                        switch(place){
                            case 1:
                                //checking out of bound exception
                                if(column + word.length() <= 16 ){
                                    word =  vertical(word , row , column);//sending word and row and column to a method 
                                }
                                //checking bonus
                                if (board[1][1] != '*')
                                {
                                    //counting bonus otherwise it will display bonus again and again
                                    if (bonus == 0){
                                        realBonus = true;
                                        bonus = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[1][11] != '*')
                                {
                                    if (bonus2 == 0){
                                        realBonus = true;
                                        bonus2 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[12][13] != '*')
                                {
                                    if (bonus3 == 0){
                                        realBonus = true;
                                        bonus3 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[10][12] != '*')
                                {
                                    if (bonus4 == 0){
                                        realBonus = true;
                                        bonus4 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[4][3] != '*')
                                {
                                    if (bonus5 == 0){
                                        realBonus = true;
                                        bonus5 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[13][3] != '*')
                                {
                                    if (bonus6 == 0){
                                        realBonus = true;
                                        bonus6 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[0][14] != ' ' )
                                {
                                    if (bonus7 == 0){
                                        hiddenBonus = true;
                                        bonus7 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if( board[14][0] != ' ')
                                {
                                    if (bonus8 == 0){
                                        hiddenBonus = true;
                                        bonus8 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }
                                else
                                {
                                    //
                                }

                                valid = true;
                                break;

                            case 2:
                                //same as above 
                                if(row + word.length() <= 16){
                                    word = horizontal(word , row ,column);
                                }

                                if (board[1][1] != '*')
                                {
                                    if (bonus == 0){
                                        realBonus = true;
                                        bonus = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[1][11] != '*')
                                {
                                    if (bonus2 == 0){
                                        realBonus = true;
                                        bonus2 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[12][13] != '*')
                                {
                                    if (bonus3 == 0){
                                        realBonus = true;
                                        bonus3 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[10][12] != '*')
                                {
                                    if (bonus4 == 0){
                                        realBonus = true;
                                        bonus4 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[4][3] != '*')
                                {
                                    if (bonus5 == 0){
                                        realBonus = true;
                                        bonus5 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[13][3] != '*')
                                {
                                    if (bonus6 == 0){
                                        realBonus = true;
                                        bonus6 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if(board[0][14] != ' ' )
                                {
                                    if (bonus7 == 0){
                                        hiddenBonus = true;
                                        bonus7 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }else{
                                    //
                                }
                                if( board[14][0] != ' ')
                                {
                                    if (bonus8 == 0){
                                        hiddenBonus = true;
                                        bonus8 = 1;
                                    }
                                    else{
                                        //
                                    }
                                }
                                else
                                {
                                    //
                                }

                                valid = true;
                                break;
                            default:// if user print invalid input

                                System.out.println("!!!!!!!!!  Please Press Valid Input :-(  !!!!!!!!");
                                valid = false;
                        }
                    }while(!valid);

                }
                else
                {
                    //
                }
            }
        }
        return word;//returning word
    }

    public String player2(){

        System.out.println("COMPUTER TURN");
        String word = "";

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

            fileReader = new FileReader("wordList.txt");

            bufferedReader = new BufferedReader(fileReader); 

            nextLine = bufferedReader.readLine();

            valid = false;
            while (!valid)
            {
                boolean val = false;
                //storing dictionary word in word variable
                word = bufferedReader.readLine();
                //taking row and column from java random class
                Random r = new Random();
                int direction = 1+r.nextInt(2); 
                row =1+ r.nextInt(15);

                column = 1+ r.nextInt(15);    

                int  length = word.length();
                boolean valids = false;
                do{
                    //switch for direction and sending word to another method
                    switch(direction){

                        case 1:
                            if(column + word.length() <= 16 ){
                                word =  vertical(word , row , column);
                            }
                            //checking bonus
                            if (board[1][1] != '*')
                            {
                                if (bonus == 0){
                                    realBonus = true;
                                    bonus = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[1][11] != '*')
                            {
                                if (bonus2 == 0){
                                    realBonus = true;
                                    bonus2 = 1;
                                }
                                else{
                                    //
                                } 
                            }else{
                                //
                            }
                            if(board[12][13] != '*')
                            {
                                if (bonus3 == 0){
                                    realBonus = true;
                                    bonus3 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[10][12] != '*')
                            {
                                if (bonus4 == 0){
                                    realBonus = true;
                                    bonus4 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[4][3] != '*')
                            {
                                if (bonus5 == 0){
                                    realBonus = true;
                                    bonus5 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[13][3] != '*')
                            {
                                if (bonus6 == 0){
                                    realBonus = true;
                                    bonus6 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[0][14] != ' ' )
                            {
                                if (bonus7 == 0){
                                    hiddenBonus = true;
                                    bonus7 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if( board[14][0] != ' ')
                            {
                                if (bonus8 == 0){
                                    hiddenBonus = true;
                                    bonus8 = 1;
                                }
                                else{
                                    //
                                }
                            }
                            else
                            {
                                //
                            } 

                            valids = true;
                            break;

                        case 2:
                            if(row + word.length() <= 16){   
                                word = horizontal(word , row ,column);
                            }
                            //checking bonus
                            if (board[1][1] != '*')
                            {
                                if (bonus == 0){
                                    realBonus = true;
                                    bonus = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[1][11] != '*')
                            {
                                if (bonus2 == 0){
                                    realBonus = true;
                                    bonus2 = 1;
                                }
                                else{
                                    //
                                } 
                            }else{
                                //
                            }
                            if(board[12][13] != '*')
                            {
                                if (bonus3 == 0){
                                    realBonus = true;
                                    bonus3 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[10][12] != '*')
                            {
                                if (bonus4 == 0){
                                    realBonus = true;
                                    bonus4 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[4][3] != '*')
                            {
                                if (bonus5 == 0){
                                    realBonus = true;
                                    bonus5 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[13][3] != '*')
                            {
                                if (bonus6 == 0){
                                    realBonus = true;
                                    bonus6 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if(board[0][14] != ' ' )
                            {
                                if (bonus7 == 0){
                                    hiddenBonus = true;
                                    bonus7 = 1;
                                }
                                else{
                                    //
                                }
                            }else{
                                //
                            }
                            if( board[14][0] != ' ')
                            {
                                if (bonus8 == 0){
                                    hiddenBonus = true;
                                    bonus8 = 1;
                                }
                                else{
                                    //
                                }
                            }
                            else
                            {
                                //
                            } 

                            valids = true;
                            break;

                    }
                }while(!valids);

                // attempt to read another line from the file
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
        //print computer row and column
        System.out.println(" Computer word is =>  " + word);

        System.out.println("Computer select " +row+ "th row " ); 
        System.out.println("Computer select " +column+ "th column");

        return word;   

    }

    /*
     * @param word row column from player 1 and 2 and returing word
     * method which identify word vertical postion if postion attached to another method than sending boolean true else false
     * method is also checking overlaping to 2 words
     */
    public String vertical(String word, int row, int column){
        int length = word.length();//variable
        //cheking for all length of word up to 7
        if(length == 2){
            if(board[row - 1][column -1] == word.charAt(0) ){
                //checking if board postion if empty or not; doing same with all method with some variation 
                if(board[row -1 ][column] == ' ' ||board[row -1][column] == '*'){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                    }
                    attach = true;
                }

            }
            else if(board[row -1][column ] == word.charAt(length -1)){
                if(board[row -1 ][column -1] == ' ' ||board[row -1][column-1] == '*' ){
                    for(int l = 0 ; l<word.length(); l++){

                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }

        }
        else if(length == 3){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == ' ' ||board[row -1][column] == '*' )&& (board[row -1][column +1 ] == ' ' ||board[row -1][column +1] == '*'))
                {
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }

                }

                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1 ] == ' ' ||board[row -1][column +1] == '*'))
                {
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' ||board[row -1][column] == '*' )&& (board[row -1][column +1 ] == word.charAt(2) ))
                {
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row -1][column +1] == word.charAt(2) ){
                if((board[row -1][column -1] == ' ' ||board[row -1][column  -1] == '*') && (board[row -1][column ] == ' ' ||board[row -1][column] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }
                else if((board[row -1][column -1] == word.charAt(0) ) && (board[row -1][column ] == ' ' ||board[row -1][column] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }
                else if((board[row -1][column -1] == ' ' ||board[row -1][column  -1] == '*') && (board[row -1][column ] == word.charAt(1))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }

            }
            else if(board[row - 1][column ] == word.charAt(1)){
                if((board[row -1][column +1] == ' ' ||board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }
                else if((board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }
                else if((board[row -1][column +1] == ' ' ||board[row -1][column +1] == '*' )&&( board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }
                }

            }
        }
        else if(length == 4){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }

                }
                else if((board[row -1][column] == word.charAt(1) )&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }

                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] ==  word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }

                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                        valid = true;
                    }

                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == word.charAt(0) )&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] ==word.charAt(3))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*' )&&( board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == word.charAt(3)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }

        }
        else if (length == 5){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else if(board[row -1][column] == word.charAt(1)){

                if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3)) &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column +1 ] == word.charAt(2)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == word.charAt(0) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column +3] == word.charAt(4)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }

        }else if (length == 6){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] ==word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column -1] == word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column] == word.charAt(1))&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column+2] == word.charAt(3)){
                if((board[row -1][column]== word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == word.charAt(0))&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == word.charAt(4))&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){

                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column+3] == word.charAt(4)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == word.charAt(0)) &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }else if(board[row - 1][column +4] == word.charAt(5)){
                if((board[row -1][column]== word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == word.charAt(0)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }

        }else if (length == 7){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column-1] ==word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] ==word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row - 1][column+3] == word.charAt(4)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else if(board[row - 1][column+4] == word.charAt(5)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == word.charAt(0)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row - 1][column +5] == word.charAt(6)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
        }
        return word;
    }

    /*
     * same as above method but for horizontal
     */
    public String horizontal(String word ,int row, int column){
        int length = word.length();

        if(length == 2){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board [row ][column  -1] == ' ' ||board [row ][column  -1] == '*' )){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);
                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row ][column  -1] == word.charAt(length -1)){

                if(board [row-1 ][column  -1] == ' ' ||board [row -1][column  -1] == '*' ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
        }
        else if(length == 3){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )) || ((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' ))|| ((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) ) ) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

            }
            else if(board[row +1][column  -1] == word.charAt(length -1)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' ))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' ))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' ))||((board [row -1][column  -1] ==  word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' ))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] ==  word.charAt(2))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }     
                    attach = true;
                    valid = true;
                }
            }

        }
        else if(length == 4){

            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] ==word.charAt(3))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) || ((board [row-1 ][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*') )|| ((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*') ) || ((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3)) ) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3)))  ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] ==word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] ==word.charAt(0) )) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else{
                attach = false;
            }

        }else if(length == 5){

            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)))  ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row +2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] ==word.charAt(1) )&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) )){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }

        }else if(length == 6){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
            else if(board[row][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] ==word.charAt(5) ))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row +4][column  -1] == word.charAt(5)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] ==word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == word.charAt(0)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
        }
        else if(length == 7){

            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }

            else if(board[row + 5][column  -1] == word.charAt(6)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if (((board [row ][column  -1] == word.charAt(1) )&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }

                    attach = true;
                    valid = true;
                }
            }else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row-1 ][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }

                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }else if(board[row + 4][column  -1] == word.charAt(5)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == word.charAt(0))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                    valid = true;
                }
            }
        }
        return word;
    }

   
    /*
     * method converting string into char and cheking value of all character
     */
    public int score(String word ){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int score = 0;
        //checking if bonus or hidden bonus is true or false
        if (realBonus){
            for(int i = 0; i < word.length(); i++) {
                for(int n = 0; n < 26; n++) {
                    // Use charAt here instead of substring
                    if(word.charAt(i) == alphabet[n])
                    {
                        score += values[n] + 1;//if bonus is true than adding 1 to each charater
                    }
                }
            }
        }
        else if(hiddenBonus){
            for(int i = 0; i < word.length(); i++) {
                for(int n = 0; n < 26; n++) {
                    // Use charAt here instead of substring
                    if(word.charAt(i) == alphabet[n])
                    {
                        score += values[n] +2;//if hidden bonus is true than adding 2 to each charater

                    }
                }
            }
        }
        else{
            for(int i = 0; i < word.length(); i++) {
                for(int n = 0; n < 26; n++) {
                    // Use charAt here instead of substring
                    if(word.charAt(i) == alphabet[n])
                    {
                        score += values[n] ;//calculating bonus
                    }
                }
            }
        }

        return score;
    }

    /*
     * back method to check plyaer want to quit game or save 
     */
    public void back(){
        valid = false;
        System.out.println("Press q => quit");
        System.out.println("Press s => save");

        do{
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            //checking user input if q than quit if s than save 
            switch(input){
                case "q":

                    valid = true;

                    break;
                case "s":
                    char [][] b = board;
                    int mr = score;
                    int mr2 = score2;
                    solo.file(b, mr , mr2);

                    valid = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    valid = false;
            }

        }while(!valid);
    }

    /*
     * @param board , player1 and player2 score
     * transfering board and score to a class which will print in file
     */
    public static void file(char[][] b ,int fufu , int fufu2) {

        System.out.println("Choose file in which you want to save game");
        System.out.println("Press 1 => Save in file 1");
        System.out.println("Press 2 => Save in file 2");
        System.out.println("Press 3 => Save in file 3");
        System.out.println("Press 4 => Save in file 4");
        System.out.println("Press 5 => Save in file 5");

        Scanner s = new Scanner(System.in);
        int user = s.nextInt();
        boolean valid = false;

        // word = g.noname();
        // System.out.println(word);
        do{
            //taking user input and asking in which file they want to store game
            switch(user){
                case 1:
                    savedFile.writeFile11(b , fufu, fufu2);
                    valid = true;
                    break;
                case 2:
                    savedFile.writeFile12(b, fufu, fufu2);
                    valid = true;
                    break;
                case 3:
                    savedFile.writeFile13(b,fufu,fufu2);
                    valid = true;
                    break;

                case 4:
                    savedFile.writeFile14(b,fufu,fufu2);
                    valid = true;

                    break;
                case 5:
                    savedFile.writeFile15(b,fufu,fufu2);
                    valid = true;
                    break;
                default :
                    valid = false;
                    System.out.println("Invalid user input");
            }
        }while(!valid);

    }

    /**
     * Method loadGame for loading game
     *
     * @param String A parameter 
     * 
     */
    public void loadGame(String ss){

        boolean valid = false;
        score(ss);
        int scr = score(ss);
        //spliting string into array and storing in different String and int
        String[] array = ss.split("}");
        String nam = array[0];
        String nam2 = array[1];
        String nam3 = array[2];
        String nam4 = array[3];
        String nam5 = array[4];
        String nam6 = array[5];
        String nam7 = array[6];
        String nam8 = array[7];
        String nam9 = array[8];
        String nam10 = array[9];
        String nam11 = array[10];
        String nam12 = array[11];
        String nam13 = array[12];
        String nam14 = array[13];
        String nam15 = array[14];
        int Sc = Integer.parseInt(array[15]);
        int Sc2 = Integer.parseInt(array[16]);
        //loops for initializing board
        for (int i = 0; i<nam.length();i++){
            char pik = nam.charAt(i);
            board[i][0] = pik;
        }

        for(int i = 0 ; i<nam2.length(); i++){
            char pika2 = nam2.charAt(i);
            board[i][1] = pika2;

        }
        for(int i = 0 ; i<nam3.length(); i++){

            char pika = nam3.charAt(i);

            board[i][2] = pika;

        }
        for(int i = 0 ; i<nam4.length(); i++){

            char pika2 = nam4.charAt(i);
            board[i][3] = pika2;

        }
        for(int i = 0 ; i<nam5.length(); i++){

            char pika5 = nam5.charAt(i);
            board[i][4] = pika5;

        }
        for(int i = 0 ; i<nam6.length(); i++){

            char pika2 = nam6.charAt(i);
            board[i][5] = pika2;

        }
        for(int i = 0 ; i<nam7.length(); i++){

            char pika2 = nam7.charAt(i);
            board[i][6] = pika2;

        }
        for(int i = 0 ; i<nam8.length(); i++){

            char pika2 = nam8.charAt(i);
            board[i][7] = pika2;

        }for(int i = 0 ; i<nam9.length(); i++){

            char pika2 = nam9.charAt(i);
            board[i][8] = pika2;

        }
        for(int i = 0 ; i<nam10.length(); i++){

            char pika2 = nam10.charAt(i);
            board[i][9] = pika2;

        }
        for(int i = 0 ; i<nam11.length(); i++){

            char pika2 = nam11.charAt(i);
            board[i][10] = pika2;

        }
        for(int i = 0 ; i<nam12.length(); i++){

            char pika2 = nam12.charAt(i);
            board[i][11] = pika2;

        }for(int i = 0 ; i<nam13.length(); i++){

            char pika2 = nam13.charAt(i);
            board[i][12] = pika2;

        }
        for(int i = 0 ; i<nam14.length(); i++){

            char pika2 = nam14.charAt(i);
            board[i][13] = pika2;

        }
        for(int i = 0 ; i<nam15.length(); i++){

            char pika2 = nam15.charAt(i);
            board[i][14] = pika2;

        }
        //displaying board
        Display();
        //displaying score of player
        System.out.println("Player1 score is - " + Sc);
        System.out.println("Player2 score is - " + Sc2);
        score = Sc;//putting score value 
        score2 = Sc2;
        //calling another method to again start game
        displayEverything();

    }

}
