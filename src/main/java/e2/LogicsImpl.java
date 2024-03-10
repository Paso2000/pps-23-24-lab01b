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
    }

    public Boolean hitMine(int row , int col) {
        return grid.isAMine(row,col);
       
    }

     public char getValueFromGrid(int row, int col ){
        return grid.getValue(row, col);
     }

     public boolean isClicked(int row, int col){
         return grid.hasBeenClicked(row,col);
     }

     
    // public Boolean isFlagged(){

    // }

    

}
