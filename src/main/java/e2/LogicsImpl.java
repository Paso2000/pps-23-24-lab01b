package e2;

public class LogicsImpl implements Logics {
    private int size;
    private int numMines;
    private Grid grid;
    public LogicsImpl(int size, int numMines) {
        this.size=size;
        this.numMines=numMines;
        implementGrid();
    }

    private void implementGrid() {
        grid = new GridImpl(this.size,this.numMines);
    }

    public Boolean cickedOnAMine(int row , int col) {
        return grid.hitMine(row,col);
       
    }

     public char getValueFromGrid(int row, int col ){
        return grid.getValue(row, col);
     }

     public boolean isClicked(int row, int col){
         return grid.hasBeenClicked(row,col);
     }


    @Override
    public void changeFlag(int row, int col) {
        grid.chageFlag(row,col);
    }

    @Override
    public boolean isFlaged(int row, int col) {
        return grid.isFlaged(row,col);
    }

    @Override
    public boolean hasWon() {
        return grid.isVictory();
    }
}
