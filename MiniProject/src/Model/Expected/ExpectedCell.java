package Model.Expected;

import Model.GenericTable.ITableCell;

public class ExpectedCell implements ITableCell {

  private final String line;
  private final int value;
  private final String probability;

  ExpectedCell(String line, String probability, int value) {
    this.line = line;
    this.probability = probability;
    this.value = value;
  }

  public String getIndex() {
    return this.probability;
  }

  public int getVal() {
    return this.value;
  }

  public String getLine() {
    return this.line;
  }
}

