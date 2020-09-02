import java.util.ArrayList;
import java.util.List;
import model.ClassicTwentyFortyEightModelImpl;
import model.TwentyFortyEightModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwentyFortyEightModelTest {

  /**
   * Tests for {@link TwentyFortyEightModel}'s genBoard function
   */
  @Test
  public void testGenBoard() {
    TwentyFortyEightModel mod = new ClassicTwentyFortyEightModelImpl();
    Assertions.assertEquals(
    "0 0 0 0 \n"
        + "0 0 0 0 \n"
        + "0 0 0 0 \n"
        + "0 0 0 0 \n", mod.getGameState());
  }

  /**
   * Tests for {@link TwentyFortyEightModel}'s merge function
   */
  @Test
  public void testMerge() {
    TwentyFortyEightModel mod = new ClassicTwentyFortyEightModelImpl();
    ArrayList array1 = new ArrayList(List.of(0,4,2,2));
    System.out.println(mod.merge(array1));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod.merge(array1));
  }
}
