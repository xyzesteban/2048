import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.ATwentyFortyEightModel;
import model.ClassicTwentyFortyEightModelImpl;
import model.OptimizedTwentyFortyEightModelImpl;
import model.TwentyFortyEightModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwentyFortyEightModelTest {

  /**
   * Tests for {@link TwentyFortyEightModel}'s initial state.
   */
  @Test
  public void testInit() {
    Random rand1 = new Random(2);
    Random rand2 = new Random(4);
    Random rand3 = new Random(8);
    Random rand4 = new Random(16);
    Random rand5 = new Random(64);
    Random rand6 = new Random(128);
    TwentyFortyEightModel mod1 = new ClassicTwentyFortyEightModelImpl(rand1);
    TwentyFortyEightModel mod2 = new ClassicTwentyFortyEightModelImpl(rand2);
    TwentyFortyEightModel mod3 = new ClassicTwentyFortyEightModelImpl(rand3);
    TwentyFortyEightModel mod4 = new ClassicTwentyFortyEightModelImpl(rand4);
    TwentyFortyEightModel mod5 = new ClassicTwentyFortyEightModelImpl(rand5);
    TwentyFortyEightModel mod6 = new ClassicTwentyFortyEightModelImpl(rand6);
    Assertions.assertEquals(
    "0 2 0 0 \n"
        + "0 0 0 0 \n"
        + "0 2 0 0 \n"
        + "0 0 0 0 \n", mod1.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "0 0 0 4 \n", mod2.getGameState());
    Assertions.assertEquals(
        "2 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "0 0 0 0 \n", mod3.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 4 0 \n"
            + "0 0 2 0 \n", mod4.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "2 0 0 0 \n"
            + "2 0 0 0 \n", mod5.getGameState());
    Assertions.assertEquals(
        "0 0 2 0 \n"
            + "0 0 0 0 \n"
            + "0 2 0 0 \n"
            + "0 0 0 0 \n", mod6.getGameState());
  }

  /**
   * Tests for {@link TwentyFortyEightModel}'s merge function
   */
  @Test
  public void testMerge() {
    ATwentyFortyEightModel mod1 = new ClassicTwentyFortyEightModelImpl();
    ArrayList array1 = new ArrayList(List.of(0,4,2,2));
    ArrayList array2 = new ArrayList(List.of(4,2,2,0));
    ArrayList array3 = new ArrayList(List.of(2,2,2,2));
    ArrayList array4 = new ArrayList(List.of(0,4,2,2,16,32,32,32));
    ArrayList array5 = new ArrayList(List.of(4,2,2,0,2,2,2,2));
    ArrayList array6 = new ArrayList(List.of(2,2,2,2,2,2,2,2));
    ArrayList array7 = new ArrayList(List.of(0,2,2,8));
    ArrayList array8 = new ArrayList(List.of(2,2,4,8));

    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod1.merge(array1));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod1.merge(array2));
    Assertions.assertEquals(mod1.merge(array1), mod1.merge(array2));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod1.merge(array3));
    // Assertions.assertEquals(new ArrayList(List.of(0,0,0,4,4,16,32,64)), mod1.merge(array4));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), mod1.merge(array5));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), mod1.merge(array6));
    Assertions.assertEquals(mod1.merge(array5), mod1.merge(array6));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,8)), mod1.merge(array7));
    Assertions.assertEquals(new ArrayList(List.of(0,4,4,8)), mod1.merge(array8));

    ATwentyFortyEightModel mod2 = new OptimizedTwentyFortyEightModelImpl();
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod2.merge(array3));
    //Assertions.assertEquals(new ArrayList(List.of(0,4,4,8)), mod2.merge(array8));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod2.merge(array1));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod2.merge(array2));
    Assertions.assertEquals(mod2.merge(array1), mod2.merge(array2));

    //Assertions.assertEquals(new ArrayList(List.of(0,0,0,4,4,16,32,64)), mod2.merge(array4));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), mod2.merge(array5));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), mod2.merge(array6));
    //Assertions.assertEquals(mod2.merge(array5), mod2.merge(array6));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,8)), mod2.merge(array7));

  }
}
