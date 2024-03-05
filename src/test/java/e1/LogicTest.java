package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {
  private static final int NUMEBER_BETWEEN_ZERO_AND_SIZE = 2;
  private static final int INTEGER_UNDER_ZERO = -1;
  private Inizializer inizializer;
  private Logics logics;
  private int size = 8;
  private Pair<Integer,Integer> pawnPosition = new Pair<Integer,Integer>(4, 3);
  private Pair<Integer,Integer> knightPosition = new Pair<Integer,Integer>(2, 2);
  private int pawnX = pawnPosition.getX();
  private int pawnY = pawnPosition.getY();
  private int knightX = knightPosition.getX();
  private int knightY= knightPosition.getY();

  @BeforeEach
  void creationTest(){
     logics = new LogicsImpl(size, pawnPosition,knightPosition);
  }
  @Test
    void boardLimitTest(){
      assertAll(
      ()->assertThrows(IndexOutOfBoundsException.class,()->logics.hit(size,NUMEBER_BETWEEN_ZERO_AND_SIZE)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(NUMEBER_BETWEEN_ZERO_AND_SIZE,size)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()-> logics.hit(size,NUMEBER_BETWEEN_ZERO_AND_SIZE)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(INTEGER_UNDER_ZERO,NUMEBER_BETWEEN_ZERO_AND_SIZE)),
      ()->assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(NUMEBER_BETWEEN_ZERO_AND_SIZE,INTEGER_UNDER_ZERO))
      );
    }


  @Test
   void failHittingtest() {
    assertFalse(logics.hit(knightX, pawnY));
  }
  @Test
   void corretHittingTest(){
    assertTrue(logics.hit(pawnX, pawnY));
  }
  @Test
    void hasKnightTest(){
      assertAll(
        ()->assertTrue(logics.hasKnight(knightX, knightY)),
        ()->assertFalse(logics.hasKnight(pawnX,knightY))
      );
  }
  @Test
  void hasPawnTest(){
      assertAll(
        ()->assertTrue(logics.hasPawn(pawnX,pawnY)),
        ()->assertFalse(logics.hasPawn(knightX, pawnY))
      );
  }
  @Test
  void createInizializer(){
  inizializer = new InizializerImpl();
  }


  @Test
  void checkInizializer(){
  inizializer = new InizializerImpl();
  Pair<Integer,Integer> newPawnPosition =inizializer.randomInit( size, pawnPosition);
  Pair<Integer,Integer> knightPosition =inizializer.randomInit( size, newPawnPosition);
  System.out.println(newPawnPosition);
  System.out.println(knightPosition);
  }
  @Test
  void utilizeLogicsWithInizializer(){
    Logics logics = new LogicsImpl(size);
  }

}
