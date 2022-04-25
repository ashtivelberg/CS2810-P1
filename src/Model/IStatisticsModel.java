package Model;

/**
 * Interfarce for a Statistical Analysis object which acts as the model in this program.
 */
public interface IStatisticsModel {

  /**
   * @param startTime starting time in HH format for when observations should occur
   * @param endTime ending time in HH format for when observations should occur
   * @param k the number of occurrences to calculate the distribution with
   * @return the poisson distribution from start time to end time given k occurrences
   */
   double findPoissonDistribution(String startTime, String endTime, int k);

  /**
   * @param line name of MBTA line
   * @return expected value of wait time for a given MBTA line
   */
   double findExpectedValue(String line);

  /**
   * @param line name of MBTA line
   * @return variance of wait time for a given MBTA line
   */
   double findVariance(String line);
}
