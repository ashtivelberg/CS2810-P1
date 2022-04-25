package Model.GenericTable;

public abstract class ATableCell implements ITableCell{

    private final String line;
    private final String index;
    private final int value;

    public ATableCell(String line, String index, int value) {
      this.line = line;
      this.index = index;
      this.value = value;
    }

    public String getLine() {
      return this.line;
    }

    public String getIndex() {
      return this.index;
    }

    public int getVal() {
      return this.value;
    }
}


