package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellsTests {
    private cell cell;
    @BeforeEach
    void cerateCell(){
        cell = new CellImpl();
    }
    @Test
    void testGEtValueFromCell(){
        assertEquals(cell.getValue(), '0');
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
        cell.setMine('3', true);
        assertAll(
        ()->assertEquals(cell.getValue(), '3'),
        ()->assertTrue(cell.isAMine())
        );
    }
}
