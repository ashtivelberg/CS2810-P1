import Model.IStatisticsModel;
import Model.StatisticsModel;

/**
 * Main class simply for running/testing/debugging the code. Also demonstrates how to switch between
 * providing a script as input v.s. allowing for user input line by line.
 */
public class Main {

  /**
   * Main method for running the Image Filtering process.
   *
   * @param args the Arguments provided by the terminal
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("Invalid Number of Args Given");
    }
    IStatisticsModel model = new StatisticsModel(args[0], args[1]);
    IView view = new StatisticsView();
    Controller controller = new Controller(model, view);
    controller.control();
  }
}