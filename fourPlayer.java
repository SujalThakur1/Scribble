import java.util.*;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class fourPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class fourPlayer{
    //declaring variable
    private char[][] board = new char [20][20];
    private int score;
    private int score3;
    private int score4;
    private int score2;
    private boolean valid;
    private int bonus;
    private int bonus8;
    private int bonus2;
    private int bonus3;
    private int bonus4;
    private int bonus5;
    private int bonus6;
    private int bonus7;
    private int bonus9;
    private int bonus10;
    private int bonus11;
    private int bonus12;
    private int bonus13;
    private int bonus14;
    private boolean attach;
    private boolean realBonus;
    private boolean hiddenBonus;
    //constructor
    public fourPlayer(){
        //initillizing board and another variable
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
        board[4][17] = '*' ;
        board[17][9] = '*' ;
        board[16][18] = '*' ;
        board[10][1] = '*' ;
        realBonus = false;
        bonus = 0;
        bonus6 = 0;
        bonus2 = 0;
        bonus3 = 0;
        bonus4 = 0;
        bonus5 = 0;
        bonus7 = 0;
        bonus8 = 0;
        bonus9 = 0;
        bonus10 = 0;
        bonus11= 0;
        bonus12 = 0;
        bonus13= 0;
        bonus14 = 0;
        hiddenBonus = false;
        valid = false;
        attach = false;
        score = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;

    }
    /*
     * display method to display board
     */
    public void Display(){
        int p = 1;
        System.out.println("    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20");
        System.out.println("  |---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|");
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
            System.out.println("\n" +"  |___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|");
        }

   
        
    }
    
    /*
     * method which end game when score is above 100 
     */
    public void gamePlay(){

        
        
        valid = false;
        boolean validss = false;

            
        do{

            String var = player1();
            if (var.equals("b")){
                valid = true;
            }
            else{

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
                    //
                }
                else if(!attach){
                    validss = false;
                    while(!validss){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        var = player1();
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
                }else{
                    Display();
                }
                score(var);
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
                System.out.println("PLAYER 2 TURN");
                validss = false;
                while(!validss){
                    String var2 = player2(); 
                    if(attach){

                        validss = true;
                        int bon2 = var2.length();
                        Display();
                        if (realBonus){
                            System.out.println("Player 2 gets " + bon2 + " point bonus");
                        }
                        else if(hiddenBonus){
                            System.out.println("Congrats player 2 you have found the hidden bonus");
                        }
                        else{
                            //
                        }

                        score2 = score2 + score(var2);

                    }
                    else if(var2.equals("0")){
                        validss = true;
                    }
                    else if(!attach){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        valid = false;
                    }
                }

                validss = false;
                while(!validss){
                    String var3 = player3(); 
                    if(attach){

                        validss = true;
                        int bon3 = var3.length();
                        Display();
                        if (realBonus){
                            System.out.println("Player 3 gets " + bon3 + " point bonus");
                        }
                        else if(hiddenBonus){
                            System.out.println("Congrats player 3 you have found the hidden bonus");
                        }
                        else{
                            //
                        }

                        score3 = score3 + score(var3);

                    }
                    else if(var3.equals("0")){
                        validss = true;
                    }
                    else if(!attach){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        valid = false;
                    }
                }

                validss = false;
                while(!validss){
                    String var4 = player4(); 
                    if(attach){

                        validss = true;
                        int bon4 = var4.length();
                        Display();
                        if (realBonus){
                            System.out.println("Player 4 gets " + bon4 + " point bonus");
                        }
                        else if(hiddenBonus){
                            System.out.println("Congrats player 4 you have found the hidden bonus");
                        }
                        else{
                            //
                        }

                        score4 = score4 + score(var4);

                    }
                    else if(var4.equals("0")){
                        validss = true;
                    }
                    else if(!attach){
                        System.out.println("Your first alphabet or last alphabet should be linked to the word exist on board ");
                        valid = false;
                    }
                }

            
             
                valid = false;

        
                System.out.println("Player1 score is - " + score);
                System.out.println("Player2 score is - " + score2);
                System.out.println("Player3 score is - " + score3);
                System.out.println("Player3 score is - " + score4);

                if(score<=99 && score2<=99 && score3<=99 && score4<=99){
                    System.out.println("press b => Back");
                }
                else{
                    //
                }
                if(score > score2 && score >= 100 && score > score3 && score > score4){
                    System.out.println("player 1 wins");
                    valid = true;
                }
                else if (score2 > score && score2 >= 100 && score2 > score3 && score2> score4){
                    System.out.println("player 2 wins");
                    valid = true;
                }
                else if (score3 > score && score3 >= 100 && score3 > score4 && score3> score2){
                    System.out.println("player 3 wins");
                    valid = true;
                }
                else if (score4 > score && score4 >= 100 && score4 > score3 && score4> score2){
                    System.out.println("player 4 wins");
                    valid = true;
                }
                else if (score == score2&&score == score3&&score == score4&&score >=100){
                    System.out.println("Its a tie between all players");
                    valid = true;
                }
                else if (score == score2&&score == score3&& score >=100){
                    System.out.println("Its a tie between players 1 and player 2 and player 3");
                    valid = true;
                }
                else if (score == score2&&score == score4&& score >=100){
                    System.out.println("Its a tie between players 1 and player 2 and player 4");
                    valid = true;
                }
                else if (score == score4&&score == score3&& score >=100){
                    System.out.println("Its a tie between players 1 and player 3 and player 4");
                    valid = true;
                }
                else if (score2 == score&&score2 == score3&& score2 >=100){
                    System.out.println("Its a tie between players 2 and player 3 and player 4");
                    valid = true;
                }
                else if (score2 == score&& score >=100){
                    System.out.println("Its a tie between players 1 and player 2");
                    valid = true;
                }
                else if (score2 == score3&& score >=100){
                    System.out.println("Its a tie between players 2 and player 3");
                    valid = true;
                }
                else if (score2 == score4&& score >=100){
                    System.out.println("Its a tie between players 2 and player 4");
                    valid = true;
                }
                else if (score == score4&& score >=100){
                    System.out.println("Its a tie between players 1 and player 4");
                    valid = true;
                }
                else if (score == score3&& score >=100){
                    System.out.println("Its a tie between players 1 and player 3");
                    valid = true;
                }
                else if (score3 == score4&& score >=100){
                    System.out.println("Its a tie between players 3 and player 4");
                    valid = true;
                }

        
            }

        
        }while(!valid);

        
        
        
        
        
    }

    /*
     * player 1 method for 1st player
     */
    public String player1(){
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
                                    board[10 - 1][10 + i -1] = p;
                                    attach = true;
                                }
                                valid = true;
                                break;

                            case 2:
                                for(int j = 0 ; j<word.length(); j++){
                                    char w = word.charAt(j);
                                    board[10 + j -1][10 - 1] = w;
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
    // method for player2
    public String player2(){

        hiddenBonus = false;//initillizing variable
        realBonus = false;//initillizing variable
        attach = false;//initillizing variable
        System.out.println("Press 0 to pass the turn");
        System.out.println("choose word between 2 to 7 words");
        String word = "" ;

        Scanner s = new Scanner(System.in);
        word = s.nextLine();
        //checking word not euals to 0 if 0 then pass turn 
        if(word.equals("0"))
        {
            valid = true;
        }else
        {
            //cheking word length
            if(word.length() >=2 && word.length() <= 7){
                boolean wordCheck;

                savedFile save = new savedFile();

                wordCheck = save.checkWord(word);//checking word is in dictionary or not
                //if word is in diction keep going else repeat
                if(wordCheck){

                }
                else{
                    System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                    do{
                        Scanner si = new Scanner(System.in);
                        word = si.nextLine();
                        wordCheck = save.checkWord(word);
                        if(word.length() >=2 && word.length() <= 7 && wordCheck){
                            valid = true;
                        }
                        else{
                            System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                            valid = false;
                        }

                    }while(!valid);

                }

            }
            else{
                System.out.println("enter valid input");
                do{
                    Scanner si = new Scanner(System.in);
                    word = si.nextLine();
                    boolean wordCheck;
                    savedFile save = new savedFile();

                    wordCheck = save.checkWord(word);

                    if(word.length() >=2 && word.length() <= 7 && wordCheck){
                        valid = true;
                    }
                    else{
                        System.out.println("Your word sholud be bigger than 1 and smaller than 7 and no speeling mistake and should be in lower case");
                        valid = false;
                    }
                }while(!valid);
            }

            int length = word.length();
            System.out.println("choose row");
            int row;
            //checking row 
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
            //checking column
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
                //checking horizontal or vertical
                switch(place){
                    case 1:
                        if(column + word.length() <= 16 ){
                            word =  vertical(word , row , column);//sending word row and column to another method 
                        }

                        //checking bonus same as player 1 
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

                    case 2:
                        //sending word to another method 
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

        return word;//returning word
    }
    
    /*
     * method for 3th player which take word from player2
     */
    public String player3(){
        System.out.println("PLAYER 3 TURN");
        String word = player2();
        return word;
    }
    /*
     * method for 4th player which take word from player2
     */
    public String player4(){
        System.out.println("PLAYER 4 TURN");
        String word = player2();

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
                    }
                    attach = true;
                }

                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1 ] == ' ' ||board[row -1][column +1] == '*'))
                {
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' ||board[row -1][column] == '*' )&& (board[row -1][column +1 ] == word.charAt(2) ))
                {
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }

            }
            else if(board[row -1][column +1] == word.charAt(2) ){
                if((board[row -1][column -1] == ' ' ||board[row -1][column  -1] == '*') && (board[row -1][column ] == ' ' ||board[row -1][column] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                }
                else if((board[row -1][column -1] == word.charAt(0) ) && (board[row -1][column ] == ' ' ||board[row -1][column] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                }
                else if((board[row -1][column -1] == ' ' ||board[row -1][column  -1] == '*') && (board[row -1][column ] == word.charAt(1))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                }

            }
            else if(board[row - 1][column ] == word.charAt(1)){
                if((board[row -1][column +1] == ' ' ||board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                }
                else if((board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                }
                else if((board[row -1][column +1] == ' ' ||board[row -1][column +1] == '*' )&&( board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
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
                    }

                }
                else if((board[row -1][column] == word.charAt(1) )&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }

                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] ==  word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }

                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }

                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == word.charAt(0) )&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] ==word.charAt(3))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*' )&&( board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == word.charAt(3)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }

        }
        else if (length == 5){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
            }
            else if(board[row -1][column] == word.charAt(1)){

                if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                }
                else if((board[row -1][column -1] == word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3)) &&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') &&( board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }

                    attach = true;
                }

            }else if(board[row - 1][column +1 ] == word.charAt(2)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == word.charAt(0) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == word.charAt(4))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column +3] == word.charAt(4)){
                if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }

        }else if (length == 6){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column] == word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] ==word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column -1] == word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3)) && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column -1] == ' ' || board[row -1][column -1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*') && (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column] == word.charAt(1))&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column+2] == word.charAt(3)){
                if((board[row -1][column]== word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == word.charAt(0))&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == word.charAt(4))&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column-1] == ' ' || board[row -1][column -1] == '*' )&& (board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){

                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column+3] == word.charAt(4)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2)) &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == word.charAt(0)) &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == word.charAt(5)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') &&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }else if(board[row - 1][column +4] == word.charAt(5)){
                if((board[row -1][column]== word.charAt(1))&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == word.charAt(2)) && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4) )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == word.charAt(0)) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&& (board[row -1][column +1] == ' ' || board[row -1][column +1] == '*') && (board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*' )&&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }

        }else if (length == 7){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);
                        attach = true;
                    }
                    attach = true;
                }

            }
            else if(board[row -1][column ] == word.charAt(1)){
                if((board[row -1][column-1] ==word.charAt(0))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column-1] == ' ' || board[row -1][column-1] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }
            else if(board[row - 1][column+1] == word.charAt(2)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] ==word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }
            else if(board[row - 1][column +2] == word.charAt(3)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == word.charAt(0) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column -1] == ' ' || board[row -1][column -1] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }
            else if(board[row - 1][column+3] == word.charAt(4)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == word.charAt(0)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }
            else if(board[row - 1][column+4] == word.charAt(5)){
                if((board[row -1][column] ==word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == word.charAt(0)) &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == word.charAt(6))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*') &&(board[row -1][column +5] == ' ' ||board[row -1][column +5] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }

            }
            else if(board[row - 1][column +5] == word.charAt(6)){
                if((board[row -1][column]== word.charAt(1))&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == word.charAt(2) )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == word.charAt(3) )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == word.charAt(4)) && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == word.charAt(5)) &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1]= word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == word.charAt(0))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if((board[row -1][column] == ' ' || board[row -1][column] == '*')&&( board[row -1][column +1] == ' ' || board[row -1][column +1] == '*' )&&( board[row -1][column +2] == ' ' || board[row -1][column +2] == '*' )&&( board[row -1][column +3] == ' ' ||board[row -1][column +3] == '*') && (board[row -1][column +4] == ' ' ||board[row -1][column +4] == '*') &&(board[row -1][column -1] == ' ' ||board[row -1][column -1] == '*')){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row -1][column +l -1] = word.charAt(l);

                    }
                    attach = true;
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
                }

            }
            else if(board[row ][column  -1] == word.charAt(length -1)){

                if(board [row-1 ][column  -1] == ' ' ||board [row -1][column  -1] == '*' ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
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
                }

            }
            else if(board[row +1][column  -1] == word.charAt(length -1)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' ))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' ))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' ))||((board [row -1][column  -1] ==  word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' ))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] ==  word.charAt(2))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }     
                    attach = true;
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
                }
            }
            else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) || ((board [row-1 ][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*') )|| ((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*') ) || ((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3)) ) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')) ||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3)))  ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] ==word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] ==word.charAt(0) )) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
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
                }
            }
            else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row +2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] ==word.charAt(1) )&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') )||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) )){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0))) ){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }

        }else if(length == 6){
            if(board[row - 1][column -1] == word.charAt(0) ){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }
            else if(board[row][column  -1] == word.charAt(1)){
                if(((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] ==word.charAt(5) ))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row +4][column  -1] == word.charAt(5)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] ==word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == word.charAt(0)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
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
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }

            else if(board[row + 5][column  -1] == word.charAt(6)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if (((board [row ][column  -1] == word.charAt(1) )&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }

                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }

                    attach = true;
                }
            }else if(board[row ][column  -1] == word.charAt(1)){
                if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row-1 ][column  -1] == word.charAt(0))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row +1][column  -1] == word.charAt(2)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }

                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == word.charAt(0) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 2][column  -1] == word.charAt(3)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == word.charAt(0))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row-1 ][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 3][column  -1] == word.charAt(4)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == word.charAt(0)) &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == word.charAt(5))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*') &&(board [row +4][column  -1] == ' ' ||board [row+4][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }else if(board[row + 4][column  -1] == word.charAt(5)){
                if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == word.charAt(1))&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == word.charAt(2) )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
                else if(((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == word.charAt(3))&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == word.charAt(4)) &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row ][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == word.charAt(0))&&(board [row +5][column  -1] == ' ' ||board [row+5][column  -1] == '*'))||((board [row][column  -1] == ' ' ||board [row][column  -1] == '*')&&(board [row+1 ][column  -1] == ' ' ||board [row+1][column  -1] == '*' )&&(board [row+2 ][column  -1] == ' ' ||board [row+2][column  -1] == '*')&&(board [row +3][column  -1] == ' ' ||board [row+3][column  -1] == '*') &&(board [row -1][column  -1] == ' ' ||board [row-1][column  -1] == '*')&&(board [row +5][column  -1] == word.charAt(6)))){
                    for(int l = 0 ; l<word.length(); l++){
                        board[row + l -1][column  -1] = word.charAt(l);

                    }
                    attach = true;
                }
            }
        }
        return word;
    }
    
    /*
     * method to quit game and save
     */
    public void back(){
        valid = false;
        System.out.println("Press q => quit");
        System.out.println("Press s => save");

        do{
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            menu m = new menu();
            switch(input){
                case "q":

                   
                    valid = true;
                    break;
                case "s":
                    char [][] b = board;
                    int mr = score;
                    int mr2 = score2;
                    int mr3 = score3;
                    int mr4 = score4;
                    fourPlayer.file(b, mr , mr2 , mr3 ,mr4);

                   
                    valid = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    valid = false;
            }

        }while(!valid);
    }
    
    /*
     * method to write to a file a board and marks of player 1 and 2
     */
    public static void file(char[][] b ,int fufu , int fufu2 , int fufu3 , int fufu4) {

        
                   
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
            switch(user){
                case 1:
                    savedFile.writeFile6(b , fufu, fufu2 ,fufu3 , fufu4);
                    valid = true;
                    break;
                case 2:
                    savedFile.writeFile7(b, fufu, fufu2,fufu3 , fufu4);
                    valid = true;
                    break;
                case 3:
                    savedFile.writeFile8(b,fufu,fufu2,fufu3 , fufu4); 
                    valid = true;
                    break;

                case 4:
                    savedFile.writeFile9(b,fufu,fufu2,fufu3 , fufu4);
                    valid = true;
                    break;
                case 5:
                    savedFile.writeFile10(b,fufu,fufu2,fufu3 , fufu4);
                    valid = true;
                    break;
                default :
                    valid = false;
                    System.out.println("Invalid user input");
            }
        }while(!valid);

        
    }
    
    /*
     * method to calculate score
     */
    public int score(String word ){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
        int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int score = 0;
        if (realBonus){
            for(int i = 0; i < word.length(); i++) {
                for(int n = 0; n < 26; n++) {
                    // Use charAt here instead of substring
                    if(word.charAt(i) == alphabet[n])
                    {
                        score += values[n] + 1;
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
                        score += values[n] +2;

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
                        score += values[n] ;
                    }
                }
            }
        }

        return score;
    }
    
    /*
     * method to load a saved game and start from the point where the game is end
     */
    public void loadGame(String ss){
        boolean valid = false;      
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
        String nam16 = array[15];
        String nam17 = array[16];
        String nam18 = array[17];
        String nam19 = array[18];
        String nam20 = array[19];
        int Sc = Integer.parseInt(array[20]);
        int Sc2 = Integer.parseInt(array[21]);
        int Sc3 = Integer.parseInt(array[22]);
        int Sc4 = Integer.parseInt(array[23]);

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
        for(int i = 0 ; i<nam16.length(); i++){

                            
            char pika2 = nam16.charAt(i);

            board[i][15] = pika2;                   

                            
        }
        for(int i = 0 ; i<nam17.length(); i++){

                            
            char pika2 = nam17.charAt(i);

            board[i][16] = pika2;                   

                            
        }
        for(int i = 0 ; i<nam18.length(); i++){

                            
            char pika2 = nam18.charAt(i);

            board[i][17] = pika2;                   

                            
        }for(int i = 0 ; i<nam19.length(); i++){
                     
            char pika2 = nam19.charAt(i);
            board[i][18] = pika2;                   
                               
                       
        }
        for(int i = 0 ; i<nam20.length(); i++){

                            
            char pika2 = nam20.charAt(i);

            board[i][19] = pika2;                   

                            
        }
        Display();
        System.out.println("Player1 score is - " + Sc);
        System.out.println("Player2 score is - " + Sc2);
        System.out.println("Player3 score is - " + Sc3);
        System.out.println("Player4 score is - " + Sc4);
        score = Sc;
        score2 = Sc2;
        score3 = Sc3;
        score4 = Sc4;

        gamePlay();

    }
}
