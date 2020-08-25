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
}
