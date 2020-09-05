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
  protected int height; // <--- int to represent the number of rows in the board
  protected int length; // <--- int to represent the number of cols in the board
  protected ArrayList<ArrayList<Integer>> board; // <--- Stores the board for the game
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
    this.height = height;
    this.length = length;
    this.board = this.genBoard();
    this.score = 0;
    this.complete = false;
    this.gameOver = false;
    this.rand = rand;
    this.newTile();
    this.newTile();
  }

  @Override
  public void move(String key) throws IllegalArgumentException {
    ArrayList<ArrayList<Integer>> newBoard;
    if (key == "right" || key == "d") {
      newBoard = moveBoard("right");
    }
    else if (key == "down" || key == "s") {
      newBoard = moveBoard("down");
    }
    else if (key == "left" || key == "a") {
      newBoard = moveBoard("left");
    }
    else if (key == "up" || key == "w") {
      newBoard = moveBoard("up");
    }
    else {
      throw new IllegalArgumentException("Invalid input. Use arrow keys or WASD to move.");
    }
    if (newBoard != this.board) {
      this.board = newBoard;
      this.newTile();
      this.newTile();
    }
  }

  /**
   * This is a helper that will return a copy of the board with the move applied. Also used to
   * check if there exist any more possible moves in isGameOver()
   * @return
   */
  public ArrayList<ArrayList<Integer>> moveBoard(String dir) {
    ArrayList<ArrayList<Integer>> newBoard = new ArrayList(this.board);
    if (dir == "right") {
      for (int i = 0; i < this.height; i++) {
        ArrayList<Integer> inputRow = new ArrayList();
        for (int j = 0; j < this.length; j++) {
          inputRow.add(this.board.get(i).get(j));
        }
        ArrayList<Integer> outputRow = this.merge(inputRow);
        for (int j = 0; j < outputRow.size(); j++) {
          newBoard.get(i).set(j, outputRow.get(j));
        }
      }
    }
    else if (dir == "down") {
      for (int j = 0; j < this.length; j++) {
        ArrayList<Integer> inputCol = new ArrayList();
        for (int i = 0; i < this.height; i++) {
          inputCol.add(this.board.get(i).get(j));
        }
        ArrayList<Integer> outputCol = this.merge(inputCol);
        for (int i = 0; i < outputCol.size(); i++) {
          newBoard.get(i).set(j, outputCol.get(i));
        }
      }
    }
    else if (dir == "left") {
      for (int i = 0; i < this.height; i++) {
        ArrayList<Integer> inputRow = new ArrayList();
        for (int j = 0; j < this.length; j++) {
          inputRow.add(this.board.get(i).get(j));
        }
        Collections.reverse(inputRow);
        ArrayList<Integer> outputRow = this.merge(inputRow);
        Collections.reverse(outputRow);
        for (int j = 0; j < outputRow.size(); j++) {
          newBoard.get(i).set(j, outputRow.get(j));
        }
      }
    }
    else if (dir == "up") {
      for (int j = 0; j < this.length; j++) {
        ArrayList<Integer> inputCol = new ArrayList();
        for (int i = 0; i < this.height; i++) {
          inputCol.add(this.board.get(i).get(j));
        }
        Collections.reverse(inputCol);
        ArrayList<Integer> outputCol = this.merge(inputCol);
        Collections.reverse(outputCol);
        for (int i = 0; i < outputCol.size(); i++) {
          newBoard.get(i).set(j, outputCol.get(i));
        }
      }
    }
    else {
      throw new IllegalArgumentException("Invalid input. Use arrow keys or WASD to move.");
    }
    return newBoard;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    // TODO: There's probably a better way to do this without for-loops or type-casting...
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
    // TODO: Will implement updating score with moves later in the project
    return this.score;
  }

  /**
   * genBoard() uses for-loops to initialize the board given the height & length that are stored
   * in this instance of the model. This function modifies the board in place and assumes the height
   * & length
   */
  public ArrayList<ArrayList<Integer>> genBoard() {
    ArrayList<ArrayList<Integer>> newBoard = new ArrayList();
    for (int i = 0; i < this.height; i++) {
      ArrayList line = new ArrayList<>();
      for (int j = 0; j < this.length; j++) {
        line.add(0);
      }
      newBoard.add(line);
    }
    return newBoard;
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
    ArrayList<Integer> copy = new ArrayList(line);
    // PUSH RIGHT
    for (int i = (int) (Math.pow(copy.size(), 2) - 1); i >= 0; i--) {
      int y = i % copy.size();
      if (y == 0) {
        continue;
      }
      if (copy.get(y) == 0 && copy.get(y - 1) != 0) {
        copy.set(y, copy.get(y - 1));
        copy.set(y - 1, 0);
      }
    }
    ArrayList<Integer> newLine = new ArrayList();
    boolean prevMerged = false;
    // MERGE
    for (int i = copy.size() - 1; i >= 0; i--) {
      if (prevMerged) {
        prevMerged = false;
        continue;
      }
      if (i == 0) {
        newLine.add(copy.get(i));
        continue;
      }
      if (copy.get(i) == copy.get(i - 1) && !prevMerged) {
        newLine.add(0);
        newLine.add(copy.get(i) * 2);
        prevMerged = true;
      }
      else {
        newLine.add(copy.get(i));
      }
    }
    Collections.reverse(newLine);
    // PUSH ONCE AGAIN
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
