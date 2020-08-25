package model;

import java.util.ArrayList;

/**
 * This class implements the TwentyFortyEightModel interface. One instance of this class
 * represents a single game of classic 2048 (2D, default is 4x4 but allows changing dimensions).
 */
public class ClassicTwentyFortyEightModelImpl implements TwentyFortyEightModel{
  ArrayList<ArrayList<Tile>> board; // <--- Contains the game board.
  int score; // <--- This variable keeps track of the score achieved by the user.
  boolean gameOver; // <--- This variable keeps track about whether or not the game is over.
  boolean complete; // TODO: For now, this tracks whether or not the user reached the 2048 Tile.

  /**
   * Default constructor for a ClassicTwentyFortyEightModelImpl.
   */
  public ClassicTwentyFortyEightModelImpl() {
    this.board = new ArrayList<ArrayList<Tile>>();
    this.score = 0;
    this.gameOver = false;
  }

  @Override
  public void move(String key) throws IllegalArgumentException {

  }

  @Override
  public ArrayList merge(ArrayList line, String key) {
    return null;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}

/**
 * This class represents one tile with a number in a classic game of 2048.
 */
class Tile {
  int value; // <--- The integer contained within this tile.

  /**
   * Default constructor for a 2048 Tile.
   */
  public Tile () {
    this.value = 0;
  }

  /**
   * Getter for this Tile's value
   * @return int representing the value contained by this tile.
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Setter for this Tile's value
   * @param newValue int to be stored in this Tile
   */
  public void setValue(int newValue) {
    this.value = newValue;
  }
}