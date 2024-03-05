package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {
  
  private Logics logics;
  private int size = 8;
  private Pair<Integer,Integer> pawnPosition = new Pair<Integer,Integer>(4, 3);
  private Pair<Integer,Integer> knightPosition = new Pair<Integer,Integer>(2, 2);


  @BeforeEach
  void creationTest(){
     logics = new LogicsImpl(size, pawnPosition,knightPosition);
  }
  @Test
    void hitExceptionTest(){
      assertAll(
      ()->assertThrows(IndexOutOfBoundsException.class,()->logics.hit(10, 2)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(0,8)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()-> logics.hit(8,2)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(-1,7)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(7,-1))
      );
    }


  @Test
   void failHittingtest() {
    assertFalse(logics.hit(3, 2));
  }
  @Test
   void corretHittingTest(){
    assertTrue(logics.hit(4, 3));
  }
  @Test
    void hasKnightTest(){
      assertAll(
      ()->assertTrue(logics.hasKnight(2, 2)),
      ()->assertFalse(logics.hasKnight(3,2))
      );
  }
  @Test
  void failHasKnight(){
      assertAll(
        ()->assertTrue(logics.hasPawn(4,3)),
        ()->assertFalse(logics.hasPawn(2, 2))
      );
  }
}
