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
        // for(int i=0;i<numMines;i++){
        //     int r1 = random.nextInt(size);
        //     int r2= random.nextInt(size);
        //    if(grid[r1][r2].getValue()!=MINE_CHAR){
        //     grid[r1][r2].setMine(MINE_CHAR,IS_A_MINE);
        //     }else{ 
        //         i--;
        //     }
        // }
        grid[1][2].setMine(MINE_CHAR,true);
        grid[2][2].setMine(MINE_CHAR, true);
        grid[3][3].setMine(MINE_CHAR, true);
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
    public Boolean clicked(int row, int col) {
        this.grid[row][col].clicked();
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
                if(i>=0 && i<size && j>=0 && j<size &&( Math.abs(i-row)==1 || Math.abs(j-col)==1)){
                    if (grid[i][j].isAMine()) {
                        count++;
                    }
                }
            }
        }
        char charValue = (char) count ;
        grid[row][col].setMine(charValue, false);   
    }

}

