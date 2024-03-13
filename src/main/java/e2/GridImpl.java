package e2;

import java.util.Random;

public class GridImpl implements Grid {

    private static final boolean IS_NOT_A_MINE = false;
    private static final char FLAG_CHAR = 'F';
    private static final boolean IS_A_MINE = true;
    private static final char MINE_CHAR = '*';
    private int size;
    private cell[][] grid;
    private int numMines;
    private boolean test;
    Random random = new Random();


    public GridImpl(int size, int numMines){
        this.size=size;
        this.numMines=numMines;
        this.test=true; //just for testing  the grid without randomness
        defaultGridValue();
        insertMine();
        insertRightValue();

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
        if(test){
            grid[1][2].setMine(MINE_CHAR,true);
        grid[2][2].setMine(MINE_CHAR, true);
        grid[3][3].setMine(MINE_CHAR, true);
        }else{
            for(int i=0;i<numMines;i++){
                int r1 = random.nextInt(size);
                int r2= random.nextInt(size);
                if(grid[r1][r2].getValue()!=MINE_CHAR){
                    grid[r1][r2].setMine(MINE_CHAR,IS_A_MINE);
                }else{ 
                    i--;
                }
            }
        }
    }

    private void insertRightValue(){
        for (int row=0;row<size;row++){
            for (int col=0; col<size;col++){
                if(!grid[row][col].isAMine())
                this.getAdiacent(row, col);
            }
        }
    }

    @Override
    public char getValue(int row, int col){
        return this.grid[row][col].getValue();
    }

    @Override
    public Boolean hitMine(int row, int col) {
        this.grid[row][col].clicked();
        if(grid[row][col].getValue()==0){
            autoClick(row, col);
        }
        return this.grid[row][col].isAMine();
    }


    @Override
    public boolean hasBeenClicked(int row, int col) {
        return grid[row][col].hasBeenClicked();
    }


    
    public void getAdiacent(int row, int col) {
        int count=0;
        for(int i=row-1; i<=row+1;i++){
            for(int j=col-1;j<=col+1;j++){
                if(i>=0 && i<size && j>=0 && j<size ){
                    if (grid[i][j].isAMine()) {
                        count++;
                    }
                }
            }
        }
        char charValue = (char) count ;
        grid[row][col].setMine(charValue, false);   
    }


    @Override
    public void autoClick(int row, int col) {
        for(int i=row-1; i<=row+1;i++){
            for(int j=col-1;j<=col+1;j++){
                if(i>=0 && i<size && j>=0 && j<size && !grid[i][j].hasBeenClicked()){
                    grid[i][j].clicked();
                    if(grid[i][j].getValue()==0){
                        autoClick(i, j);
                    }
                }
            }
        }
    }


    @Override
    public void chageFlag(int row, int col) {
        cell cell = grid[row][col];
        cell.changeFlag();

    }


    @Override
    public boolean isFlaged(int row, int col) {
        return grid[row][col].isFlaged();
    }


    @Override
    public boolean hasWon() {
        for(int row=0; row<size;row++){
            for (int col=0;col<size;col++){
                cell cell = grid[row][col];
                if(cell.isAMine() && !cell.isFlaged()){
                    return false;
                }
                else if(!cell.hasBeenClicked()){
                    return false;
                }
            }
        }
        return true;
    }
}

