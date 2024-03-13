package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {
    private Grid grid;
    private int size=8;
    private int numMines=5;
    int row =2;
    int col = 3;
      @BeforeEach 
    void createGrid(){
        grid = new GridImpl(size, numMines);

    }


    @Test
    void testMineInGrid(){
    for (int i=0; i<size; i++){
      for (int j=0;j<size; j++){
        char value = grid.getValue(i,j);
        if(grid.hitMine(i, j)){
          assertEquals(value, '*');
        }
      }
    }
  }

@Test
  void adiacentMines(){
    grid.getAdiacent(row,col);
    assertEquals(3,grid.getValue(row, col));
  } 

  @Test
  void testAutoClick(){
  grid.autoClick(row,col);
  assertTrue(grid.hasBeenClicked(row-1, col));
  }

  @Test
  void testFlag(){
    grid.chageFlag(row, col);
    assertTrue(grid.isFlaged(row, col));
  }

}