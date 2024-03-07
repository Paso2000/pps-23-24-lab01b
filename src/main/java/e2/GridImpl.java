package e2;

import java.util.List;
import java.util.Random;

public class GridImpl implements Grid {

    private static final boolean IS_A_MINE = true;
    private static final char MINE_CHAR = '*';
    private cell[][] grid;
    private int size;
    private int numMines;
    Random random = new Random();


    public GridImpl(int size, int numMines){
        this.size=size;
        this.numMines=numMines;
        grid = new cell[size][size];
        insertMine();
    }

    private void implementGrid(int size) {
    }
    
    public cell[][] getGrid() {
        return grid;
    }

    private void insertMine(){
        for(int i=0;i<numMines;i++){
            grid[random.nextInt(size)][random.nextInt(size)]=new CellImpl(MINE_CHAR,IS_A_MINE);
            }
    }

    @Override
    public List<cell> getAdjacent(cell cell) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdjacent'");
    }
}
