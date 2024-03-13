package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellsTests {
    private static final boolean IS_A_MINE = true;
    private static final char MINE_CHAR = '*';
    private static final char DEFAULT_VALUE = '0';
    private cell cell;
    @BeforeEach
    void cerateCell(){
        cell = new CellImpl();
    }
    @Test
    void testGEtValueFromCell(){
        assertEquals(cell.getValue(), DEFAULT_VALUE);
    }
    @Test
    void falseHasBeenClicked(){
        assertFalse(cell.hasBeenClicked());
    }
    @Test
    void hasBeenClicked(){
        assertFalse(cell.hasBeenClicked());
        cell.clicked();
        assertTrue(cell.hasBeenClicked());
    }

    @Test
    void setCell(){
        cell.setMine(MINE_CHAR, IS_A_MINE);
        assertAll(
        ()->assertEquals(cell.getValue(), MINE_CHAR),
        ()->assertTrue(cell.isAMine())
        );
    }

    @Test
    void setFlag(){
        cell.changeFlag();
        assertTrue(cell.isFlaged());
    }
    @Test
    void setDoubleFlag(){
        cell.changeFlag();
        cell.changeFlag();
        assertFalse(cell.isFlaged());
    }
}
