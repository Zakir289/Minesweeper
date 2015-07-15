package com.company;

/**
 * Created by zakir on 15/7/15.
 */
import java.util.Random;
import java.util.Scanner;

public class Grid {
    private int[][] mines;
    private char[][] actualGrid;
    private int row, Column;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Grid(){
        mines = new int[10][10];
        actualGrid = new char[10][10];
        initialzieMines();   //fill with zero's
        placeMines();  //get the random numbers and place 10 mines
        fillNoOfSurroundingNeighbours();     //based on the mines 8 boxes surronding the mine will be calculated and shown to the player
        startBoard();   //This fills the actual board

    }


    public boolean win(){
        int count=0;
        for(int line = 1 ; line < 9 ; line++)
            for(int column = 1 ; column < 9 ; column++)
                if(actualGrid[line][column]=='#')
                    count++;
        if(count == 10)
            return true;
        else
            return false;
    }

    public void revealNeighbours(){
        for(int i=-1 ; i<2 ; i++)
            for(int j=-1 ; j<2 ; j++)
                if (mines[row +i][Column+j] != -1)
                    actualGrid[row +i][Column+j]=Character.forDigit(mines[row +i][Column+j], 10);

    }

    public int getPosition(int Line, int Column){
        return mines[Line][Column];
    }

    public boolean readAndSetPosition(){

        do{
            System.out.print("\nrow: ");
            row = input.nextInt();
            System.out.print("Column: ");
            Column = input.nextInt();

            if( (actualGrid[row][Column] != '*') && ((row < 9 && row > 0) && (Column < 9 && Column > 0)))
                System.out.println("Field already shown");

            if( row < 1 || row > 8 || Column < 1 || Column > 8)
                System.out.println("Choose a number between 1 and 8");

        }while((row < 1 || row > 8 || Column < 1 || Column > 8) || (actualGrid[row][Column] != '*') );

        if(getPosition(row, Column)== -1)
            return true;
        else
            return false;

    }

    public void showGrid(){
        System.out.println("\n     Lines");
        for(int Line = 8 ; Line > 0 ; Line--){
            System.out.print("       "+Line + " ");

            for(int Column = 1 ; Column < 9 ; Column++){
                System.out.print("   "+ actualGrid[Line][Column]);
            }

            System.out.println();
        }

        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Columns");

    }

    public void fillNoOfSurroundingNeighbours(){
        for(int line=1 ; line < 9 ; line++)
            for(int column=1 ; column < 9 ; column++){

                for(int i=-1 ; i<=1 ; i++)
                    for(int j=-1 ; j<=1 ; j++)
                        if(mines[line][column] != -1)
                            if(mines[line+i][column+j] == -1)
                                mines[line][column]++;

            }

    }

    public void revealMines(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(mines[i][j] == -1)
                    actualGrid[i][j]='#';

        showGrid();
    }

    public void startBoard(){
        for(int i=1 ; i<mines.length ; i++)
            for(int j=1 ; j<mines.length ; j++)
                actualGrid[i][j]= '*';
    }

    public void initialzieMines(){
        for(int i=0 ; i<mines.length ; i++)
            for(int j=0 ; j<mines.length ; j++)
                mines[i][j]=0;
    }

    public void placeMines(){
        boolean raffled;
        int Line, Column;
        for(int i=0 ; i<10 ; i++){

            do{
                Line = random.nextInt(8) + 1;
                Column = random.nextInt(8) + 1;

                if(mines[Line][Column] == -1)
                    raffled=true;
                else
                    raffled = false;
            }while(raffled);

            mines[Line][Column] = -1;
        }
    }
}
