package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinesweeperLogicsTests {
    private static int COL = 3;
    private static int ROW = 2;
    private int size=8;
    private int numMines = 5;
    private Logics logics;
    private Pair<Integer,Integer> pos= new Pair<Integer,Integer>(3, 2);
    
    @BeforeEach
    void crateLogics(){
        logics = new LogicsImpl(size, numMines);
    }

    @Test
    void failHitMineTest(){
        assertFalse(logics.cickedOnAMine(pos.getX(),pos.getY()));
    }
    @Test
    void testGetValueToPrint(){

        assertEquals((int)logics.getValueFromGrid(ROW, COL), 3);
    }
    @Test
    void insertFlag(){
        logics.changeFlag(ROW,COL);
        assertTrue(logics.isFlaged(ROW,COL));
        
    }

    @Test
    void doubleChangeFlag(){
        logics.changeFlag(ROW, COL);
        logics.changeFlag(ROW, COL);
        assertFalse(logics.isFlaged(ROW, COL));
    }


  

    
}
