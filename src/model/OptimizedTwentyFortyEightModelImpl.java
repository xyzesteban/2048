package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class extends the {@link ATwentyFortyEightModel} abstract class and implements the
 * {@link TwentyFortyEightModel} interface. One object of the model represents one instance of a
 * game of 2048. All of the constructors and methods necessary to run a game of 2048 can be found
 * in the abstract class, implemented as default behavior. Constructors in this class use calls to
 * super-constructor. No methods were overriden.
 */
public class OptimizedTwentyFortyEightModelImpl extends ATwentyFortyEightModel{
  /**
   * First constructor takes no parameters. Initializes the game with a default height of 4 and
   * length of 4. Two tiles will be randomly placed on the board at the beginning of the game.
   */
  public OptimizedTwentyFortyEightModelImpl() {
    super(4, 4, new Random());
  }

  /**
   * Second constructor takes a Random object for testing. Initializes the game with a default
   * height of 4 and length of 4. Two tiles will be placed on the board, and their placement is
   * determined by the Random object provided (a seed may be provided to the Random object).
   *
   * @param rand Random object that can be specified during unit testing
   */
  public OptimizedTwentyFortyEightModelImpl(Random rand) {
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
  public OptimizedTwentyFortyEightModelImpl(int height, int length) {
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
  public OptimizedTwentyFortyEightModelImpl(int height, int length, Random rand) {
    super(height, length, rand);
  }

  /**
   * merge() is the method that contains the logic to move a single row or column in a 2048 game.
   * This implementation of the method does the following two actions:
   *     1. MERGE adjacent tiles containing the same number once.
   *     2. PUSH non-zero numbers to the rightmost possible position.
   * @param line an ArrayList to be "merged"
   * @return A brand new ArrayList with the required changes.
   */
  @Override
  public ArrayList merge(ArrayList<Integer> line) {
    ArrayList<Integer> newLine = new ArrayList();
    ArrayList<Integer> zeroes = new ArrayList();
    for (int i = line.size() - 1; i >= 0; i--) {
      int n = line.get(i);
      if (n == 0) {
        zeroes.add(0);
      } else if (!newLine.isEmpty() && newLine.get(newLine.size() - 1) == n) {
        newLine.set(newLine.size() - 1, n * 2);
        zeroes.add(0);
      } else {
        newLine.add(line.get(i));
      }
    }
    zeroes.addAll(newLine);
    return zeroes;
  }
}
