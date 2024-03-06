package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellsTests {
    private static final char DEDAULT_VALUE = '2';
    private cell cell;
    @BeforeEach
    void cerateCell(){
        cell = new CellImpl(DEDAULT_VALUE);
    }
    @Test
    void testGEtValueFromCell(){
        assertEquals(cell.getValue(), DEDAULT_VALUE);
    }

}
