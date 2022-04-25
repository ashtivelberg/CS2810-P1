package Model.Expected;

import Model.GenericTable.Table;
import Model.GenericTable.TableCell;
import Model.Utils;
import java.util.ArrayList;
import java.util.List;

public class ExpectedTable {

  private final List<ExpectedCell> table;

  public ExpectedTable(String filename) {
    Utils.nullCheck(filename);
    this.table = makeExpectedTable(filename);
  }

  private static List<ExpectedCell> makeExpectedTable(String filename) {
    List<ExpectedCell> table = new ArrayList<ExpectedCell>();
    Table generic = new Table(filename);
    List<TableCell> genericTableList = generic.getTable();
    for (int i = 0; i < genericTableList.size(); i++) {
      TableCell t = genericTableList.get(i);
      table.add(new ExpectedCell(t.getLine(), Double.parseDouble(t.getIndex()), t.getVal()));
    }
    return table;
  }

  public double expectedValue(String line) {
    Utils.nullCheck(line);
    double expectedValue = 0;
    for (ExpectedCell tb : this.table) {
      if (tb.getLine().equals(line)) {
        expectedValue += tb.getVal() * tb.getProbability();
      }
    }
    return expectedValue;
  }

  public double variance(String line) {
    Utils.nullCheck(line);
    double expectedValue = 0;
    for (ExpectedCell tb : this.table) {
      if (tb.getLine().equals(line)) {
        expectedValue += Math.pow(tb.getVal(), 2) * tb.getProbability();
      }
    }
    return expectedValue;
  }
}
