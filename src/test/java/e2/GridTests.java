package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {
    private Grid grid;
    private int size=8;
      @BeforeEach 
    void createGrid(){
        grid = new GridImpl();
    }
    @Test
    void createGridCollection(){
       grid = grid.createGrid(size);

    }

}
