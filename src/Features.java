interface Features {

  /**
   * @param input follows format "HH HH k" where HH are start & end time and k is the
   *              number of occurrences
   * @return the poisson distribution from starting time to ending time of k events
   */
  double poissionDistribution(String input);

  /**
   * @param input the MBTA line to use for data
   * @return the expected value of wait time for a given MBTA line
   */
  double expectedValue(String input);

  /**
   * @param input the MBTA line to use for data
   * @return the variance of wait time for a given MBTA line
   */
  double variance(String input);
}
