package model;

import java.util.ArrayList;

/**
 * This interface represents the operations offered by the 2048 model. One instance of a model
 * that implements this interface represents one game of 2048.
 */
public interface TwentyFortyEightModel {

  /**
   * Adds new tiles on the board at the beginning and after a move is made by the player. For
   * classic 2048, the number can either be 2 or 4
   */
  void newTile();

  /**
   * Move all the tiles in the direction of the arrow keys. A move is valid if and only if there
   * is at least one tile that can move in the specified direction without anything blocking its
   * path. Specific implementations may place additional constraints on the validity of a move.
   * @param key A String representing the input from the user
   * @throws IllegalArgumentException if an invalid key is pressed or the move is not possible.
   */
  void move(String key) throws IllegalArgumentException;

  /**
   * Helper function to merge single line or column in the 2048 board and returns the result in the
   * form of an ArrayList. If the move is not valid or causes no change, it will return the
   * unchanged ArrayList, but in such a case it would be ideal to not call this function.
   * TODO: Figure out some logic to see if line is merge-able and only call this when needed.
   * @param line The row or column to be merged.
   * @param key A String representing the input from the user.
   */
  ArrayList merge(ArrayList line);

  /**
   * Return whether the game is over or not. A game is over if no more moves can be made, or if
   * the target score (if there is one) has been reached.
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Return a string that represents the state of the board at the time of evaluating this
   * function. The string should have one line per row of the game board. Each tile in the game
   * board is a power of 2 and will be formatted to display according to the size of the number.
   * @return A String representation of the game board
   */
  String getGameState();

  /**
   * Return the score achieved by the player at the time of evaluating this function. Specific
   * implementations may use different rules on how score is calculated and used.
   * @return int representing the player's score
   */
  int getScore();
}
