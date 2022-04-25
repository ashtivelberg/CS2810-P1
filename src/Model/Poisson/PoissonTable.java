package Model.Poisson;

import Model.GenericTable.Table;
import Model.GenericTable.TableCell;
import Model.Utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    Table generic = new Table(filename);
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
    int start = Utils.parseTimeToMin(startTime);
    int end = Utils.parseTimeToMin(endTime);
    Utils.nullCheck(k);
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

/**
 * people wait at station for x long, poisson distribution
 * <p>
 * expected value of trip time, wait time, variance of wait time
 * <p>
 * hypothesis test that a tool is going to improve people's satisfaction of the t
 */
