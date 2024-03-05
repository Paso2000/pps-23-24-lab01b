package e2;

import org.junit.jupiter.api.Test;

public class MinesweeperLogicsTests {
    private int size=8;
    private int numMines = 5;
    @Test
    void crateLogics(){
            Logics logics = new LogicsImpl(size, numMines);
    }
}
