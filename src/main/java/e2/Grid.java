package e2;

import java.util.List;

public interface Grid {

    public char getValue(int row, int col);

	public Boolean isAMine(int row, int col);

    public boolean hasBeenClicked(int row, int col);
    
}
