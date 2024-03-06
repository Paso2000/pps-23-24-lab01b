package e2;

import java.util.List;

public interface Grid {

    public Grid createGrid(int size);

    public List<cell> getAdjacent(cell cell);
    
}
