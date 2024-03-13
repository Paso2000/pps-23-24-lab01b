package e2;

public interface Grid {

    public char getValue(int row, int col);

	public Boolean hitMine(int row, int col);

    public boolean hasBeenClicked(int row, int col);

    public void getAdiacent(int row, int col);

    public void autoClick(int row, int col);

    public void chageFlag(int row, int col);

    public boolean isFlaged(int row, int col);

    public boolean hasWon();
    
}
