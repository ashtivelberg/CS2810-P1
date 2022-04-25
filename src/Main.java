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
    Readable rd = null;
    Appendable ap = System.out;
    StatisticsModel model = new StatisticsModel("test.csv", "expected.csv");
    IView view = new StatisticsView();
    Controller controller = new Controller(model, view);
    controller.control();
  }
}