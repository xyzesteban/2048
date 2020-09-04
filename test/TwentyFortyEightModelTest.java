import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.ATwentyFortyEightModel;
import model.ClassicTwentyFortyEightModelImpl;
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
    ATwentyFortyEightModel mod = new ClassicTwentyFortyEightModelImpl();
    ArrayList array1 = new ArrayList(List.of(0,4,2,2));
    ArrayList array2 = new ArrayList(List.of(4,2,2,0));
    ArrayList array3 = new ArrayList(List.of(2,2,2,2));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod.merge(array1));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod.merge(array2));
    Assertions.assertEquals(mod.merge(array1), mod.merge(array2));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod.merge(array3));
  }
}
