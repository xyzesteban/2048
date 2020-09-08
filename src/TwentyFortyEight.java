import controller.*;
import model.*;
import java.io.InputStreamReader;

/**
 * The main TwentyFortyEight class is the main object to run the Marble Solitaire game. It includes
 * the main() method which acts as the entry point for the Marble Solitaire program.
 */
public class TwentyFortyEight {

  /**
   * The main() method is the entry point for the Marble Solitaire program. This method takes
   * inputs as command-line arguments. The program will decide which board shape,
   * board size, and initial empty position to use according to the user input.
   * Omitting the -size or - hole arguments initializes the game to defaults for the given model.
   *
   * @param args console input from the user to decide which MarbleSolitaireModel to use
   */
  public static void main(String[] args) {
    Readable in = new InputStreamReader(System.in);
    Appendable out = System.out;
    System.out.println("Welcome to 2048!\n");
    new TwentyFortyEightControllerImpl(in, out).playGame(new ClassicTwentyFortyEightModelImpl());
  }
}