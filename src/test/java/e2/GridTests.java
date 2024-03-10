package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {
    private Grid grid;
    private int size=8;
    private int numMines=5;
    int row =1;
    int col = 2;
      @BeforeEach 
    void createGrid(){
        grid = new GridImpl(size, numMines);

    }
    @Test
    void createGridCollection(){
    for (int i=0; i<size; i++){
      for (int j=0;j<size; j++){
        char c = grid.getValue(i,j);
        if(grid.isAMine(i, j)){
          assertEquals(c, '*');
        }else{
          assertEquals(c, '0');
        }
      }
    }
      }
      // @Test
      // void testMine(){
      // assertAll(
      //   ()->assertFalse(grid.isAMine(row, col)),
      //   ()->assertTrue(grid.hasBeenClicked(row, col))
      // );
      // }



    


}
