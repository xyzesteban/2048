package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This abstract class implements the {@link model.TwentyFortyEightModel} interface and provides
 * various useful operations to run a game of TwentyFortyEight. Default behavior for this class
 * runs the original 2048 implementation with a 4x4 board, but the height and length may be changed
 * and a Random object may be specified for unit testing as well. This object cannot be constructed
 * directly but may be freely extended by other classes as needed.
 *
 * TODO: Explore what other configurations may be created for 2048 and what elements they share
 */
public abstract class ATwentyFortyEightModel implements TwentyFortyEightModel {
  protected ArrayList<ArrayList<Integer>> board; // <--- Stores the board for the game as an ArrayList
  protected int height; // <--- int to represent the number of rows in the board
  protected int length; // <--- int to represent the number of cols in the board
  protected int score; // <--- int to keep track of the score achieved by the user
  protected boolean complete; // <--- Has the user reached the 2048 tile?
  protected boolean gameOver; // <--- Are no more moves possible?
  protected Random rand; // <--- Random object to add tiles to the board

  /**
   * First constructor takes no parameters. Initializes the game with a default height of 4 and
   * length of 4. Two tiles will be randomly placed on the board at the beginning of the game.
   */
  public ATwentyFortyEightModel() {
    this(4, 4, new Random());
  }

  /**
   * Second constructor takes a Random object for testing. Initializes the game with a default
   * height of 4 and length of 4. Two tiles will be placed on the board, and their placement is
   * determined by the Random object provided (a seed may be provided to the Random object).
   *
   * @param rand Random object that can be specified during unit testing
   */
  public ATwentyFortyEightModel(Random rand) {
    this(4,4, rand);
  }

  /**
   * Third constructor takes two parameters: height & length. Initializes the game with the
   * height and length values specified by the user or by unit tests. Two tiles will be randomly
   * placed on the board at the beginning of the game.
   *
   * @param height number of rows in this instance of 2048
   * @param length number of columns in this instance of 2048
   */
  public ATwentyFortyEightModel(int height, int length) {
    this(height, length, new Random());
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
  public ATwentyFortyEightModel(int height, int length, Random rand) {
    if (height <= 0 || length <= 0) {
      throw new IllegalArgumentException("Values for height & length must be positive numbers.");
    }
    this.board = new ArrayList();
    this.height = height;
    this.length = length;
    this.score = 0;
    this.complete = false;
    this.gameOver = false;
    this.rand = rand;
    this.genBoard();
    this.newTile();
    this.newTile();
  }

  @Override
  public void move(String key) throws IllegalArgumentException {
    ArrayList<ArrayList<Integer>> newBoard = new ArrayList();
    if (key == "right" || key == "D") {
      for (int i = 0; i < this.height; i++) {
        newBoard.add(this.merge(this.board.get(i)));
      }
    }
    else if (key == "down" || key == "S") {
      // TODO
    }
    else if (key == "left" || key == "A") {
      for (int i = 0; i < this.height; i++) {
        newBoard.add(this.merge(this.board.get(i)));
        Collections.reverse(newBoard.get(i));
      }
    }
    else if (key == "up" || key == "W") {
      // TODO
    }
    else {
      throw new IllegalArgumentException("Invalid input. Use arrow keys or WASD to move.");
    }
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    // TODO: There's probably a better way to do this without for loops or type-casting...
    String out = "";
    for (int i = 0; i < this.board.size(); i++) {
      String line = "";
      for (int j = 0; j < this.board.get(i).size(); j++) {
        line += this.board.get(i).get(j);
        line += " ";
      }
      line += "\n";
      out += line;
    }
    return out;
  }

  @Override
  public int getScore() {
    return 0;
  }

  /**
   * genBoard() uses for-loops to initialize the board given the height & length that are stored
   * in this instance of the model. This function modifies the board in place and assumes the height
   * & length
   */
  public void genBoard() {
    for (int i = 0; i < this.height; i++) {
      ArrayList line = new ArrayList<>();
      for (int j = 0; j < this.length; j++) {
        line.add(0);
      }
      this.board.add(line);
    }
  }

  /**
   * newTile() will spawn one number, either 2 or 4, on a random position within the board. For a
   * default implementation of TwentyFortyEight, the method is called twice at the beginning of the
   * game, and twice after every move done by the user.
   */
  public void newTile() {
    boolean zero = false;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < length; j++) {
        if (this.board.get(i).get(j) == 0) {
          zero = true;
        }
      }
    }
    if (zero) {
      int targetYPos = this.rand.nextInt(this.height);
      int targetXPos = this.rand.nextInt(this.length);

      while (this.board.get(targetYPos).get(targetXPos) != 0) {
        targetYPos = this.rand.nextInt(this.height);
        targetXPos = this.rand.nextInt(this.length);
      }

      ArrayList newNums = new ArrayList(List.of(2,2,2,2,2,4,2,2,2,2));
      int number = (int) newNums.get(this.rand.nextInt(newNums.size()));

      this.board.get(targetYPos).set(targetXPos, number);
    }
  }

  /**
   * merge() is the method that contains the logic to move a single row or column in a 2048 game.
   * This implementation of the method does the following two actions:
   *     1. MERGE adjacent tiles containing the same number once.
   *     2. PUSH non-zero numbers to the rightmost possible position.
   *
   * @param line an ArrayList to be "merged"
   * @return A brand new ArrayList with the required changes.
   */
  public ArrayList merge(ArrayList<Integer> line) {
    // TODO: Implement the optimized algorithm in a separate ModelImpl class.
    ArrayList<Integer> newLine = new ArrayList();
    boolean prevMerged = false;
    // MERGE
    for (int i = 0; i < line.size(); i++) {
      if (prevMerged) {
        prevMerged = false;
        continue;
      }
      if (i == line.size() - 1) {
        newLine.add(line.get(i));
        continue;
      }
      if (line.get(i) == line.get(i + 1) && !prevMerged) {
        newLine.add(0);
        newLine.add(line.get(i) * 2);
        prevMerged = true;
      }
      else {
        newLine.add(line.get(i));
      }
    }
    // PUSH
    for (int i = (int) (Math.pow(newLine.size(), 2) - 1); i >= 0; i--) {
      int y = i % newLine.size();
      if (y == 0) {
        continue;
      }
      if (newLine.get(y) == 0 && newLine.get(y - 1) != 0) {
        newLine.set(y, newLine.get(y - 1));
        newLine.set(y - 1, 0);
      }
    }
    return newLine;
  }
}
