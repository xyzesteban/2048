package model;

import java.util.Random;

/**
 * This class extends the {@link ATwentyFortyEightModel} abstract class and implements the
 * {@link TwentyFortyEightModel} interface. One object of the model represents one instance of a
 * game of 2048. All of the constructors and methods necessary to run a game of 2048 can be found
 * in the abstract class, implemented as default behavior. Constructors in this class use calls to
 * super-constructor. No methods were overriden.
 */
public class ClassicTwentyFortyEightModelImpl extends ATwentyFortyEightModel{

  /**
   * First constructor takes no parameters. Initializes the game with a default height of 4 and
   * length of 4. Two tiles will be randomly placed on the board at the beginning of the game.
   */
  public ClassicTwentyFortyEightModelImpl() {
    super(4, 4, new Random());
  }

  /**
   * Second constructor takes a Random object for testing. Initializes the game with a default
   * height of 4 and length of 4. Two tiles will be placed on the board, and their placement is
   * determined by the Random object provided (a seed may be provided to the Random object).
   *
   * @param rand Random object that can be specified during unit testing
   */
  public ClassicTwentyFortyEightModelImpl(Random rand) {
    super(4, 4, rand);
  }

  /**
   * Third constructor takes two parameters: height & length. Initializes the game with the
   * height and length values specified by the user or by unit tests. Two tiles will be randomly
   * placed on the board at the beginning of the game.
   *
   * @param height number of rows in this instance of 2048
   * @param length number of columns in this instance of 2048
   */
  public ClassicTwentyFortyEightModelImpl(int height, int length) {
    super(height, length, new Random());
  }

  /**
   * Fourth constructor takes a Random object for testing & height & length parameters. Initializes
   * the game with the height and length values specified by the user or by unit tests. Two tiles
   * will be placed on the board, and their placement is determined by the Random object provided,
   * in a similar manner to the second constructor.
   *
   * @param height number of rows in this instance of 2048
   * @param length number of columns in this instance of 2048
   * @param rand Random object that can be specified during unit testing
   */
  public ClassicTwentyFortyEightModelImpl(int height, int length, Random rand) {
    super(height, length, rand);
  }
}