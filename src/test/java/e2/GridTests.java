package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {
    private static final int OFFSET = 1;
    private static final int COL = 3;
    private static final int ROW = 2;
    private static final int THREE_MINES_ADIACENT = 3;
    private Grid grid;
    private int size=8;
    private int numMines=5;

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
    grid.getAdiacent(ROW,COL);
    assertEquals(THREE_MINES_ADIACENT,grid.getValue(ROW, COL));
  } 

  @Test
  void testAutoClick(){
  grid.autoClick(ROW,COL);
  assertTrue(grid.hasBeenClicked(ROW-OFFSET, COL));
  }

  @Test
  void testFlag(){
    grid.chageFlag(ROW, COL);
    assertTrue(grid.isFlaged(ROW, COL));
  }

  @Test
  void testVicory(){
    assertFalse(grid.isVictory());
  }

}