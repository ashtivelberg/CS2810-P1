package Model.Expected;

/**
 * Class representing data for a CSV Table modeled to compute expected value & variance
 */
public interface IExpectedTabe {

  /**
   * Expected Value, E[X] is calculated by finding the sum of each entry asked for multiplied by
   * the probability for that entry happening.
   *
   * @param line name of MBTA line
   * @return the expected value of wait times for the MBTA line
   */
   double expectedValue(String line);

  /**
   * Variance is calculated by computing the expected value for each entry squared minus the
   * expected value squared for a given entry
   *
   * @param line name of MBTA line
   * @return the variance of wait times for the MBTA line
   */
   double variance(String line);
}
