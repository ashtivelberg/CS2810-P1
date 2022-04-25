package Model.Expected;

import Model.GenericTable.ATableCell;
import Model.GenericTable.ITableCell;

public class ExpectedCell extends ATableCell implements ITableCell {

  ExpectedCell(String line, String probability, int value) {
    super(line, probability, value);
  }
}

