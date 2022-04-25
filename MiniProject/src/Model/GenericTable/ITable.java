package Model.GenericTable;

import java.util.List;

/**
 * Representation of CSV document following a specific format.
 */
public interface ITable {

  /**
   * Returns the table.
   *
   * @return the list of table entries
   */
  List<TableCell> getTable();
}
