import Model.IStatisticsModel;
import Model.StatisticsModel;
import Model.Utils;
import java.io.IOException;

public class Controller implements Features {

  private final IStatisticsModel model;
  private final IView view;

  public Controller(IStatisticsModel model, IView view) {
    this.model = Utils.nullCheck(model);
    this.view = view;
    view.addFeatures(this);
  }

  public void control() {
    view.makeVisible();
  }

  @Override
  public double poissionDistribution(String input) {
    Utils.nullCheck(input);
    String[] parts = input.split(" ");
    if (parts.length != 3) {
      throw new IllegalArgumentException("Invalid Number of Args");
    }
    double ret = 0.0;
    try {
      ret = this.model.findPoissonDistribution(parts[0], parts[1], Integer.parseInt(parts[2]));
    } catch (Exception e) {
      write(e.getMessage());
    }
    return ret;
  }

  @Override
  public double expectedValue(String input) {
    Utils.nullCheck(input);
    return this.model.findExpectedValue(input);
  }

  @Override
  public double variance(String input) {
    Utils.nullCheck(input);
    double ret = 0.0;
    try {
      ret = this.model.findVariance(input);
    } catch (Exception e) {
      write(e.getMessage());
    }
    return ret;
  }

  /**
   * Appends the given message and prints it if successful; handles exception IOException but throws
   * IAE.
   *
   * @param message the message wishing to be written to the Appendable object
   */
  private void write(String message) {
    try {
      view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("Could not Append Message");
    }
  }
}
