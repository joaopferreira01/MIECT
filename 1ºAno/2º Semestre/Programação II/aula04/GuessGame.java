import static java.lang.System.*;
import java.util.Random;

public class GuessGame {
  private int min;
  private int max;
  private int secretNumber; // to hold the secret
  private int attempt;
  private int numAttempts;
  // ...

  public GuessGame(int min, int max) {
    this.min = min;
    this.max = max;
    Random random = new Random();
    this.secretNumber = random.nextInt(this.max - this.min) + this.min;
    numAttempts = 0;
  }

  public int min() {
    return this.min;
  }

  public int max() {
    return this.max;
  }
  public int secretNumber(){
    return secretNumber;
  }

  public boolean validAttempt(int n) {
    if (n >= this.min && n <= this.max) {
      return true;
    }
    return false;
  }

  public boolean finished() {
    if (attempt == secretNumber) {
      return true;
    }
    return false;
  }

  public boolean attemptIsHigher() {
    if (attempt > secretNumber) {
      return true;
    }
    return false;
  }

  public boolean attemptIsLower() {
    if (attempt < this.secretNumber) {
      return true;
    }
    return false;
  }

  public void play(int n) {
    // ...
    assert validAttempt(n) : "Tentativa inválida!";
    assert !finished() : "O jogo já terminou"; // false passa a true => jogo continua
    attempt = n;
    numAttempts++;
    if(finished()){
      System.out.printf("Game finished in %d attempts", numAttempts());
      exit(1);
    }else if(attemptIsHigher()){
      System.out.printf("\n%d is too high!", attempt);
    }else{
      System.out.printf("\n%d is too low!", attempt);
    }
  }

  public int numAttempts() {
    return numAttempts;
  }

  /**
   * Simple tests of the GuessGame class. This method tests the functionality of
   * the GuessGame class. It should be used by the programmer to test and debug
   * the class. It is not meant to be called in client programs.
   *
   * To run from the command line, use: java -ea GuessGame
   */
  public static void main(String[] args) {
    requireEA();
    out.println("Starting tests.");
    GuessGame game = new GuessGame(1, 10);
    // initial tests:
    assert !game.finished() : "game should not be finished yet";
    assert game.min() == 1;
    assert game.max() == 10;
    assert game.numAttempts() == 0 : "there should be no attempts yet";
    int a = 0;
    for (int i = -10; i <= 20; i++) {
      assert game.validAttempt(i) == (i >= 1 && i <= 10);
    }
    // trying all wrong answers:
    int nplay = 0; // how may times play was called
    for (int n = 1; n <= 10; n++) {
      if (n != game.secretNumber) {
        game.play(n); // make a wrong guess
        nplay++;
        assert game.numAttempts() == nplay;
        assert !game.finished() : "game should not be finished yet";
        assert (n < game.secretNumber) == game.attemptIsLower() : "Algo de errado 1";
        assert (n > game.secretNumber) == game.attemptIsHigher() : "Algo de errado 2";
      }
    }
    // make the right guess:
    game.play(game.secretNumber);
    nplay++;
    assert game.finished() : "game should be finished now";
    assert game.numAttempts() == nplay;
    out.println("No error detected!");
  }

  /** Check if program is being run with -ea, exit if not. */
  static void requireEA() {
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) {
      err.println("This program must be run with -ea!");
      exit(1);
    }
  }

}
