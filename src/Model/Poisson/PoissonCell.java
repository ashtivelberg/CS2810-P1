package Model.Poisson;

import Model.GenericTable.ATableCell;
import Model.GenericTable.ITableCell;
import Model.Utils;

public class PoissonCell implements ITableCell {

  private final String line;
  private final int value;
  private int[] times = new int[2];

   PoissonCell(String line, String start, String end, int value) {
    this.line = line;
    this.times[0] = Utils.parseTimeToMin(start) >= 0 ? Utils.parseTimeToMin(start) : null;
    this.times[1] = Utils.parseTimeToMin(end) >= 0 ? Utils.parseTimeToMin(end) : null;
    this.value = value;
  }

  public int getStart() {
    return this.times[0];
  }

  public int getEnd() {
    return this.times[1];
  }

  public int getVal() {
    return this.value;
  }

  public String getLine() {
    return this.line;
  }

  @Override
  public String getIndex() {
    return String.valueOf(this.getStart())+ String.valueOf(this.getEnd());
  }
}

