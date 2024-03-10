package e2;

import java.util.Random;

public class GridImpl implements Grid {

    private static final boolean IS_A_MINE = true;
    private static final char MINE_CHAR = '*';
    private int size;
    private cell[][] grid;
    private int numMines;
    Random random = new Random();


    public GridImpl(int size, int numMines){
        this.size=size;
        this.numMines=numMines;
        defaultGridValue();
        insertMine();
    }


    private void defaultGridValue() {
        this.grid = new cell[size][size];
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++){
                this.grid[row][col]= new CellImpl();
            }
        }
    }

    private void insertMine(){
        for(int i=0;i<numMines;i++){
           if(grid[random.nextInt(size)][random.nextInt(size)].getValue()!=MINE_CHAR){
            grid[random.nextInt(size)][random.nextInt(size)].setValue(MINE_CHAR);
            grid[random.nextInt(size)][random.nextInt(size)].setIsAMine(IS_A_MINE);
            }else{ i--;
            }
        }
        //grid[1][2].setIsAMine(true);
    }

    public char getValue(int row, int col){
        return this.grid[row][col].getValue();
    }

    @Override
    public Boolean isAMine(int row, int col) {
        grid[row][col].clicked();
        return grid[row][col].isAMine();
    }


    @Override
    public boolean hasBeenClicked(int row, int col) {
        return grid[row][col].hasBeenClicked();
    }

}

