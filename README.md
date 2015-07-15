# MineSweeper

The above code has grid class which contain all the functionalities related to grid. Its not complete implementation of the MineSweeper.

- The game conatains 10 Mines in 8*8 grid. 
- You can find the line and column number surrounded around the grid.
- for every turn you need provide a line no and column no, if there is no mine present at that unit then all the 8 boxes surrounding that unit will be opened which contains no of mines surrounding that unit.
- For example, if you choose a location, and it appears the number '3' there is because there are three mines around of that place. It is noteworthy that 'around' mean all blocks around, including the diagonals ones.


#### output of the program

![output] (https://github.com/Zakir289/Minesweeper/blob/master/DocumentedImgaes/Minesweeper.png)

##### Minesweeper in object oriented way

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
 
