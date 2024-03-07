package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellsTests {
    private static final boolean IS_NOT_A_MINE = false;
    private static final char DEDAULT_VALUE = '2';
    private cell cell;
    @BeforeEach
    void cerateCell(){
        cell = new CellImpl(DEDAULT_VALUE,IS_NOT_A_MINE);
    }
    @Test
    void testGEtValueFromCell(){
        assertEquals(cell.getValue(), DEDAULT_VALUE);
    }

}
