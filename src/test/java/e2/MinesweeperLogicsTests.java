package e2;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.PrimitiveIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinesweeperLogicsTests {
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
        assertFalse(logics.hitMine(pos));
    }
    @Test
    void createGrid(){
        Grid grid = new GridImpl(size);
    };
}
