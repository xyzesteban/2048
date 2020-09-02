package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class implements the TwentyFortyEightModel interface. One instance of this class
 * represents a single game of classic 2048 (2D, default is 4x4 but allows changing dimensions).
 */
public class ClassicTwentyFortyEightModelImpl implements TwentyFortyEightModel{
  ArrayList<ArrayList<Integer>> board; // <--- Contains the game board.
  int length; // <--- Stores this board's length
  int height; // <--- Stores this board's height
  int score; // <--- This variable keeps track of the score achieved by the user.
  boolean gameOver; // <--- This variable keeps track about whether or not the game is over.
  // TODO: For now, this tracks whether or not the user reached the 2048 Tile.
  // NOTE: The user should be able to keep playing after reaching 2048.
  boolean complete; // <--- Keeps track of whether or not the user reached the 2048 tile.

  /**
   * Default constructor for a ClassicTwentyFortyEightModelImpl.
   */
  public ClassicTwentyFortyEightModelImpl() {
    this.board = new ArrayList<>(); // The board status is stored in a two-dimensional array.
    this.length = 4;
    this.height = 4;
    this.score = 0;this.gameOver = false;
    this.genBoard(4,4);
  }

  /**
   * This function generates the starting board for the game.
   * TODO: For future implementations, may move to interface / abstract class
   */
  private void genBoard(int length, int height) {
    for (int i = 0; i < height; i++) {
      ArrayList line = new ArrayList<>();
      for (int j = 0; j < length; j++) {
        line.add(0);
      }
      this.board.add(line);
    }
    newTile();
    newTile();
  }

  /**
   * This method will spawn one number which can be either 2 or 4 with randomized positions. In
   * this class, the method is called at the start of the game and once a move makes a change in
   * the board.
   */
  @Override
  public void newTile() {
    Random rand = new Random();
    boolean zero = false;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < length; j++) {
        if (this.board.get(i).get(j) == 0) {
          zero = true;
        }
      }
    }
    if (zero) {
      int targetYPos = rand.nextInt(this.height);
      int targetXPos = rand.nextInt(this.length);

      while (this.board.get(targetYPos).get(targetXPos) != 0) {
        targetYPos = rand.nextInt(this.height);
        targetXPos = rand.nextInt(this.length);
      }

      ArrayList newNums = new ArrayList(List.of(2,2,2,2,2,4,2,2,2,2));
      int number = (int) newNums.get(rand.nextInt(newNums.size()));

      this.board.get(targetYPos).set(targetXPos, number);
    }
  }

  @Override
  public void move(String key) throws IllegalArgumentException {

  }

  @Override
  public ArrayList merge(ArrayList line) {
    
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    // TODO: There's probably a better way to do this. Avoid for-loops and type-casting
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
}