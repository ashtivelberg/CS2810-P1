package Model.Expected;

import Model.GenericTable.GenericTable;
import Model.GenericTable.ITable;
import Model.GenericTable.TableCell;
import Model.Utils;
import java.util.ArrayList;
import java.util.List;

public class ExpectedTable implements ITable, IExpectedTabe {

  private final List<ExpectedCell> table;

  public ExpectedTable(String filename) {
    Utils.nullCheck(filename);
    this.table = makeExpectedTable(filename);
  }

  private static List<ExpectedCell> makeExpectedTable(String filename) {
    List<ExpectedCell> table = new ArrayList<ExpectedCell>();
    ITable generic = new GenericTable(filename);
    List<TableCell> genericTableList = generic.getTable();
    for (int i = 0; i < genericTableList.size(); i++) {
      TableCell t = genericTableList.get(i);
      table.add(new ExpectedCell(t.getLine(), t.getIndex(), t.getVal()));
    }
    return table;
  }

  public double expectedValue(String line) {
    if (!lines.contains(line.toLowerCase()))
    {
      throw new IllegalArgumentException("Line Name Doesn't Exist");
    }
    Utils.nullCheck(line);
    double expectedValue = 0;
    for (ExpectedCell tb : this.table) {
      if (tb.getLine().equals(line)) {
        expectedValue += tb.getVal() * Double.parseDouble(tb.getIndex());
      }
    }
    return expectedValue;
  }

  public double variance(String line) {
    if (!lines.contains(line.toLowerCase()))
    {
      throw new IllegalArgumentException("Line Name Doesn't Exist");
    }
    Utils.nullCheck(line);
    double expectedValue = 0;
    for (ExpectedCell tb : this.table) {
      if (tb.getLine().equals(line)) {
        expectedValue += Math.pow(tb.getVal(), 2) * Double.parseDouble(tb.getIndex());
      }
    }
    return expectedValue;
  }

  @Override
  public List<TableCell> getTable() {
    return this.getTable();
  }
}
