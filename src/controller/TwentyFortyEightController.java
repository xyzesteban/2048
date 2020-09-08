package controller;

import model.TwentyFortyEightModel;

/**
 * This interface represents a control for the I/O of a game of 2048. Works in conjunction with
 * an implementation of (@link TwentyFortyEightModel}.
 */
public interface TwentyFortyEightController {

  /**
   * Plays a new game of 2048 using the provided {@link TwentyFortyEightModel}.
   *
   * @param model an instance of TwentyFortyEightModel to represent the game.
   * @throws IllegalArgumentException if the provided model is null.
   * @throws IllegalStateException if the controller is unable to transmit I/O.
   * TODO: Think about whether the second exception is necessary as you implement.
   */
  void playGame(TwentyFortyEightModel model) throws IllegalArgumentException;
}
