package controller;

import java.util.ArrayList;
import java.util.List;
import model.TwentyFortyEightModel;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements the {@link TwentyFortyEightModel} and controls the I/O for a game of 2048.
 * Works in conjunction with a {@link TwentyFortyEightModel} object which receives input from a
 * Readable object. The output is then displayed with an Appendable object.
 */
public class TwentyFortyEightControllerImpl implements TwentyFortyEightController{
  private final Readable rd; // TODO: This variable may not be needed.
  private final Appendable ap;

  /**
   * Constructor for the controller class to accept and store objects for input and output. Both
   * arguments can be defined separately for testing and do not need to come from user input.
   *
   * @param rd Object to receive input from the user (NOT NULL).
   * @param ap Object to write output to the console for the user (NOT NULL).
   */
  public TwentyFortyEightControllerImpl(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Invalid Readable or Appendable: <null>");
    }
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * Plays a new game of 2048 using the provided {@link TwentyFortyEightModel}
   *
   * @param model an instance of TwentyFortyEightModel to represent the game.
   * @throws IllegalArgumentException if the provided model is null.
   */
  @Override
  public void playGame(TwentyFortyEightModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model: <null>");
    }
    try {
      this.ap.append(model.getGameState() + "\nScore: " + model.getScore() + "\n");
      Scanner scan = new Scanner(this.rd);
      while (!model.isGameOver()) {
        if (scan.hasNextLine()) {
          String message = scan.nextLine();
          if (message.equalsIgnoreCase("q")) {
            this.ap.append("Game quit!\nState of game when quit:\n"
                + model.getGameState() + "\nScore: " + model.getScore());
            return;
          }
          else {
            try {
              model.move(message);
              this.ap.append(model.getGameState() + "\nScore: " + model.getScore() + "\n");
            } catch (IllegalArgumentException ex) {
              this.ap.append(ex.getMessage() + "\n");
            }
          }
        }
      }
      this.ap.append("Game over!\n" + model.getGameState() + "\nScore: " + model.getScore());
    }
    catch (IOException ex) {
      throw new IllegalStateException(ex.getMessage());
    }
  }
}
