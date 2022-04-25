package Model.GenericTable;


/**
 * A cell in a CSV table
 */
public interface ITableCell {

  /**
   * @return the MBTA line a cell belongs to
   */
  String getLine();

  /**
   * @return the first column value for a cell
   */
  String getIndex();

  /**
   * @return the value of a cell
   */
  int getVal();
}
