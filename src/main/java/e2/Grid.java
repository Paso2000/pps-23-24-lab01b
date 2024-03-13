package e2;

public interface Grid {

    public char getValue(int row, int col);

	public Boolean clickedOnAMine(int row, int col);

    public boolean hasBeenClicked(int row, int col);

    public void getAdiacent(int row, int col);

    public void autoClick(int row, int col);
    
}
