package Model;

import Model.Expected.ExpectedTable;
import Model.Poisson.PoissonTable;

public class StatisticsModel implements IStatisticsModel{

  PoissonTable poissonTable;
  ExpectedTable expectedTable;

  public StatisticsModel(String poissonTablePath, String expectedTablePath) {
    this.poissonTable = new PoissonTable(poissonTablePath);
    this.expectedTable = new ExpectedTable(expectedTablePath);
  }

  @Override
  public double findPoissonDistribution(String startTime, String endTime, int k) {
    return this.poissonTable.poissionDistribution(startTime, endTime, k);
  }

  @Override
  public double findExpectedValue(String line) {
    return this.expectedTable.expectedValue(line);
  }

  @Override
  public double findVariance(String line) {
    return this.expectedTable.variance(line);
  }
}
