import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.ATwentyFortyEightModel;
import model.ClassicTwentyFortyEightModelImpl;
import model.OptimizedTwentyFortyEightModelImpl;
import model.TwentyFortyEightModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link TwentyFortyEightModel}s. Includes ### comprehensive tests for the basic
 * functionality and logic necessary for 2048 implementations in this program.
 */
public class TwentyFortyEightModelTest {
  Random rand1;
  Random rand2;
  Random rand3;
  Random rand4;
  Random rand5;
  Random rand6;
  ATwentyFortyEightModel mod0;
  ATwentyFortyEightModel modO;
  TwentyFortyEightModel mod1;
  TwentyFortyEightModel mod2;
  TwentyFortyEightModel mod3;
  TwentyFortyEightModel mod4;
  TwentyFortyEightModel mod5;
  TwentyFortyEightModel mod6;
  ArrayList<Integer> array1;
  ArrayList<Integer> array2;
  ArrayList<Integer> array3;
  ArrayList<Integer> array4;
  ArrayList<Integer> array5;
  ArrayList<Integer> array6;
  ArrayList<Integer> array7;
  ArrayList<Integer> array8;
  ArrayList<Integer> array9;


  public void initData() {
    this.rand1 = new Random(2);
    this.rand2 = new Random(4);
    this.rand3 = new Random(8);
    this.rand4 = new Random(16);
    this.rand5 = new Random(64);
    this.rand6 = new Random(128);
    this.mod0 = new ClassicTwentyFortyEightModelImpl();
    this.modO = new OptimizedTwentyFortyEightModelImpl();
    this.mod1 = new ClassicTwentyFortyEightModelImpl(this.rand1);
    this.mod2 = new ClassicTwentyFortyEightModelImpl(this.rand2);
    this.mod3 = new ClassicTwentyFortyEightModelImpl(this.rand3);
    this.mod4 = new ClassicTwentyFortyEightModelImpl(this.rand4);
    this.mod5 = new ClassicTwentyFortyEightModelImpl(this.rand5);
    this.mod6 = new ClassicTwentyFortyEightModelImpl(this.rand6);
    this.array1 = new ArrayList(List.of(0,4,2,2));
    this.array2 = new ArrayList(List.of(4,2,2,0));
    this.array3 = new ArrayList(List.of(2,2,2,2));
    this.array4 = new ArrayList(List.of(0,4,2,2,16,32,32,32));
    this.array5 = new ArrayList(List.of(4,2,2,0,2,2,2,2));
    this.array6 = new ArrayList(List.of(2,2,2,2,2,2,2,2));
    this.array7 = new ArrayList(List.of(0,2,2,8));
    this.array8 = new ArrayList(List.of(2,2,4,8));
    this.array9 = new ArrayList(List.of(4,2,0,2));
  }

  /**
   * Tests for {@link TwentyFortyEightModel}'s getGameState function & initial state.
   */
  @Test
  public void testGetGameState() {
    this.initData();
    Assertions.assertEquals(
    "0 2 0 0 \n"
        + "0 0 0 0 \n"
        + "0 2 0 0 \n"
        + "0 0 0 0 \n", this.mod1.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "0 0 0 4 \n", this.mod2.getGameState());
    Assertions.assertEquals(
        "2 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "0 0 0 0 \n", this.mod3.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "0 0 4 0 \n"
            + "0 0 2 0 \n", this.mod4.getGameState());
    Assertions.assertEquals(
        "0 0 0 0 \n"
            + "0 0 0 0 \n"
            + "2 0 0 0 \n"
            + "2 0 0 0 \n", this.mod5.getGameState());
    Assertions.assertEquals(
        "0 0 2 0 \n"
            + "0 0 0 0 \n"
            + "0 2 0 0 \n"
            + "0 0 0 0 \n", this.mod6.getGameState());
  }

  /**
   * Tests for {@link TwentyFortyEight}'s move method.
   */
  @Test
  public void testMove() {
    this.initData();
    this.mod1.move("right");
    Assertions.assertEquals(
        "0 0 0 2 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "2 0 0 2 \n", this.mod1.getGameState());
    this.mod1.move("down");
    Assertions.assertEquals(
        "0 0 2 0 \n"
            + "0 0 0 0 \n"
            + "0 0 0 2 \n"
            + "2 0 2 4 \n", this.mod1.getGameState());
    this.mod1.move("left");
    Assertions.assertEquals(
        "2 0 2 0 \n"
            + "0 0 0 0 \n"
            + "2 0 0 0 \n"
            + "4 4 2 0 \n", this.mod1.getGameState());
    this.mod1.move("up");
    Assertions.assertEquals(
        "4 4 4 0 \n"
            + "4 2 0 0 \n"
            + "0 0 0 0 \n"
            + "0 2 0 0 \n", this.mod1.getGameState());
    this.mod1.move("d");
    Assertions.assertEquals(
        "0 0 4 8 \n"
            + "0 4 4 2 \n"
            + "0 0 0 0 \n"
            + "0 0 2 2 \n", this.mod1.getGameState());
    this.mod1.move("s");
    Assertions.assertEquals(
        "2 0 0 2 \n"
            + "0 0 0 0 \n"
            + "0 0 8 8 \n"
            + "0 4 2 4 \n", this.mod1.getGameState());
    this.mod1.move("a");
    Assertions.assertEquals(
        "4 0 2 0 \n"
            + "0 0 0 0 \n"
            + "16 0 2 0 \n"
            + "4 2 4 0 \n", this.mod1.getGameState());
    this.mod1.move("w");
    Assertions.assertEquals(
        "4 2 4 0 \n"
            + "16 0 4 0 \n"
            + "4 0 2 2 \n"
            + "0 0 0 0 \n", this.mod1.getGameState());
  }

  /**
   * Tests for {@link TwentyFortyEightModel}'s merge method.
   */
  @Test
  public void testMerge() {
    this.initData();
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.mod0.merge(array1));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.mod0.merge(array2));
    Assertions.assertEquals(this.mod0.merge(array1), this.mod0.merge(array2));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), mod0.merge(array3));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,4,4,16,32,64)), this.mod0.merge(array4));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), mod0.merge(array5));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), this.mod0.merge(array6));
    Assertions.assertEquals(this.mod0.merge(array5), this.mod0.merge(array6));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,8)), this.mod0.merge(array7));
    Assertions.assertEquals(new ArrayList(List.of(0,4,4,8)), this.mod0.merge(array8));
    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.mod0.merge(array9));

    Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.modO.merge(array3));
    //Assertions.assertEquals(new ArrayList(List.of(0,4,4,8)), this.modO.merge(array8));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.modO.merge(array1));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.modO.merge(array2));
    Assertions.assertEquals(this.modO.merge(array1), this.modO.merge(array2));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,0,4,4,16,32,64)), this.modO.merge(array4));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), this.modO.merge(array5));
    Assertions.assertEquals(new ArrayList(List.of(0,0,0,0,4,4,4,4)), this.modO.merge(array6));
    //Assertions.assertEquals(this.modO.merge(array5), this.modO.merge(array6));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,8)), this.modO.merge(array7));
    //Assertions.assertEquals(new ArrayList(List.of(0,0,4,4)), this.modO.merge(array9));

  }
}
