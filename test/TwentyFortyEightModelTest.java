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
    Assertions.assertEquals(mod.getGameState(),
    "0 0 0 0\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n");
  }

  /**
   * Tests for {@link TwentyFortyEightModel}'s merge function
   */
  @Test
  public void testMerge() {
    TwentyFortyEightModel mod = new ClassicTwentyFortyEightModelImpl();
    ArrayList array1 = new ArrayList(List.of(0,4,2,2));
    Assertions.assertEquals(mod.merge(array1), new ArrayList(List.of(0,0,4,4)));
  }
}
