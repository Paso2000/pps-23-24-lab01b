package e2;

public interface Grid {

    public char getValue(int row, int col);

	public Boolean clicked(int row, int col);

    public boolean hasBeenClicked(int row, int col);

    public void getAdiacent(int row, int col);
    
}
