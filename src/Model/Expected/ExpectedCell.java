package Model.Expected;

public class ExpectedCell {

  private final String line;
  private final int value;
  private double probability;

  ExpectedCell(String line, double probability, int value) {
    this.line = line;
    this.probability = probability;
    this.value = value;
  }

  public double getProbability() {
    return this.probability;
  }

  public int getVal() {
    return this.value;
  }

  public String getLine() {
    return this.line;
  }
}

