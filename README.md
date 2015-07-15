# MineSweeper

The above code has grid class which contain all the functionalities related to grid. Its not complete implementation of the MineSweeper.

- The game conatains 10 Mines in 8*8 grid. 
- You can find the line and column number surrounded around the grid.
- for every turn you need provide a line no and column no, if there is no mine present at that unit then all the 8 boxes surrounding that unit will be opened which contains no of mines surrounding that unit.
- For example, if you choose a location, and it appears the number '3' there is because there are three mines around of that place. It is noteworthy that 'around' mean all blocks around, including the diagonals ones.


#### output of the program

![output] (https://github.com/Zakir289/Minesweeper/blob/master/DocumentedImgaes/Minesweeper.png)

#### Lets do Minsweeper in OOPS way

- In the above code I had used two arrays and try maintain the info in two arrays. Instead of writing two arrays, I thought of declaring every single cell as **Unit** object.
- **Unit**
 Here goes the **Unit** class which represents a cell in the grid
 
```java


public class Unit {
    public enum State{
        REVEALED,UNKNOWN
    }

    public enum Value{
        MINE, NUMBER, EMPTY
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    State state;
    Value value;
    
    public Unit(){
	state = State.UNKNOWN;
    value = Value.EMPTY;
    }


}
```

I had declared state and value as enum because those are only the values those variable will occupy
 

- Next to Unit class we need Write the qualities of Grid. To make it simple I want make Grid as 2-Dimensional array of **Unit** classes. 

I want to declare Grid as a interface and then extend it as a class with some additional functionalities.

Here goes the interface

```java
public interface GridTemplate {
    public void revealNeighbours();
    public void showGrid();
    public void revealMines();
    public void placeMines();
    public void createBoard();
    public void placeNumbers();
    public void playAnotherGame();
    public boolean isGameOver();
}

```

You can include many other functionalities like 2D grid or 3D grid, no of users playing the game(if you want), Reading the input, ....

The basic class implementation for the above code goes here

```java

public class Grid implements GridTemplate {

    Unit unit[][] = new Unit[8][8];// can be replaced by user choice about the grid layout
    
    @Override
    public void revealNeighbours() {
        /*when user chooses particular unit and if it is not mine, then other units will be shown */
    }

    @Override
    public void showGrid() {
        /* This function shows the grid evertime to the user so that he can choose wisely*/

    }

    @Override
    public void revealMines() {
/* Once the user looses the game, All the hidden mines are revelaed*/
    }

    @Override
    public void placeMines() {
/* if necessery get the information from the user about no of mines, By using Random function place the mines randomly on the grid*/
    }

    @Override
    public void createBoard() {
/* creates the grid with initializieng the two dimensionaly array and few other stuff*/
    }

    @Override
    public void placeNumbers() {
/* Based on the no of mines placed by the randon function we need fill the other boxes accordingly with numbers */
    }

    @Override
    public void playAnotherGame() {

    }

    @Override
    public boolean isGameOver() {
        /* */
    }
}
```


This is so simple implementation of **MineSweeper** program in OOPS, you can divide the Grid class into more classes.At the same time you can  declare Unit as Interface with some standard qualities and then create Unit class with some additional functionalities and so on
