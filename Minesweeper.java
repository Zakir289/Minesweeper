package com.company;

/**
 * Created by zakir on 15/7/15.
 */
public class Minesweeper {
    private Grid grid;
    boolean finish = false;
    int turn=0;

    public Minesweeper(){
        grid = new Grid();
        startGame(grid);
    }

    public static void main(String[] args) {
      new Minesweeper();

    }

    public void startGame(Grid grid){
        do{
            turn++;
            System.out.println("Turn "+turn);
            grid.showGrid();                //Shows the grid till the game is won or lost
            finish = grid.readAndSetPosition();//reads the input and checks if there is mine or not

            if(!finish){
                grid.revealNeighbours();//opens surronding 8 neighbohors
                finish = grid.win();
            }

        }while(!finish);

        if(grid.win()){
            System.out.println("Congratulations, you Won the game in  "+turn+" turns :)");
            grid.revealMines();
        } else {
            System.out.println("ooh you step over the Mine, :(");
            grid.revealMines();
        }
    }
}
