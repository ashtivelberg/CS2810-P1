package Model.Poisson;

import Model.GenericTable.GenericTable;
import Model.GenericTable.ITable;
import Model.GenericTable.TableCell;
import Model.Utils;
import java.util.ArrayList;
import java.util.List;

public class PoissonTable {

  private final List<PoissonCell> table;

  public PoissonTable(String filename) {
    Utils.nullCheck(filename);
    this.table = makePoissonTable(filename);
  }

  // parses a single line from the csv file to create a list of entries
  private static List<PoissonCell> makePoissonTable(String filename) {
    List<PoissonCell> table = new ArrayList<PoissonCell>();
    ITable generic = new GenericTable(filename);
    List<TableCell> genericTableList = generic.getTable();
    for (int i = 0; i < genericTableList.size(); i++) {
      TableCell t = genericTableList.get(i);
      String startTime = t.getIndex().substring(0, 2);
      String endTime = t.getIndex().substring(3, 5);
      table.add(new PoissonCell(t.getLine(), startTime, endTime, t.getVal()));
    }
    return table;
  }

  public double poissionDistribution(String startTime, String endTime, int k) {
    Utils.nullCheck(startTime);
    Utils.nullCheck(endTime);
    Utils.nullCheck(k);
    int start = Utils.parseTimeToMin(startTime);
    int end = Utils.parseTimeToMin(endTime);
    if (start > end) {
      throw new IllegalArgumentException("End Time Before Start Time");
    }
    double sum = 0;
    double count = 0;
    for (PoissonCell tb : this.table) {
      if (tb.getStart() >= start && tb.getEnd() <= end) {
        sum += tb.getVal();
        count++;
      }
    }
    double lambda = sum / count;
    return (Math.pow(lambda, k) * Math.exp(-lambda)) / Utils.fact(k);
  }
}
