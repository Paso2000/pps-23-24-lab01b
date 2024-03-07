package e2;

import java.util.List;

public interface Grid {

    public cell[][] getGrid();
    
    public List<cell> getAdjacent(cell cell);

}
