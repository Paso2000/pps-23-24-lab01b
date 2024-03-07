package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {
    private Grid grid;
    private int size=8;
    private int numMines=5;
      @BeforeEach 
    void createGrid(){
        grid = new GridImpl(size, numMines);
    }
    @Test
    void createGridCollection(){
      cell[][] createdGrid = grid.getGrid();
      for(int i=0;i<size;i++){
        for(int j =0;j<size;j++){
        System.out.println(createdGrid[i][j].getValue());
        }
      }



    }

}
