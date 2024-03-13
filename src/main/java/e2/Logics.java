package e2;

public interface Logics {

   public Boolean cickedOnAMine(int row, int col);
    
    public char getValueFromGrid(int row, int col);

    public boolean isClicked(int row, int col);

    public void changeFlag(int row, int col);

    public boolean isFlaged(int row, int col);

    public boolean hasWon();
}
