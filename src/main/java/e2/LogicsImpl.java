package e2;

import java.util.LinkedList;
import java.util.List;

public class LogicsImpl implements Logics {
    private int size;
    private int numMines;
    private Grid grid;
    private cell[][] createdGrid;

    public LogicsImpl(int size, int numMines) {
        this.size=size;
        this.numMines=numMines;
        implementGrid();
    }

    private void implementGrid() {
        grid = new GridImpl(this.size,this.numMines);
        createdGrid=grid.getGrid();
    }

    public Boolean hitMine(int row , int col) {
        createdGrid[row][col].clicked();
        if(createdGrid[row][col].getValue()=='*'){
            return true;
        }
        return false;

    }

    // public Boolean isFlagged(){

    // }

    // public char getCounter(){

    // }

    

}
