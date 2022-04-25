package Model.GenericTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ATable implements ITable {

  public final List<TableCell> table;

  public ATable(String table) {
    this.table = readTable(table);
  }

  // creates list of entries with relevant info for each box that contains data in graph
  private static List<TableCell> readTable(String filename) {
    List<TableCell> table = new ArrayList<>();
    Path pathToFile = Paths.get(filename);
    try (BufferedReader br = Files.newBufferedReader(pathToFile,
        StandardCharsets.US_ASCII)) {

      // complicated java code for creating string array with line names
      // and filtered out empty lines
      String[] mbtaLineNames = Arrays.stream(br.readLine().split(",")).filter(value -> value !=
          null && value.length() > 0).toArray(size -> new String[size]);

      String line = br.readLine();
      while (line != null) {
        String[] entry = line.split(",");
        List<TableCell> row = createTableEntry(entry, mbtaLineNames);
        table.addAll(row);
        line = br.readLine();
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("Error Reading CSV File");
    }
    for (int i = 0; i < table.size(); i++) {
      System.out.println(
          table.get(i).getIndex() + " " + table.get(i).getLine() + " " + table.get(i).getVal());
    }
    return table;
  }

  // parses a single line from the csv file to create a list of entries
  private static List<TableCell> createTableEntry(String[] entry, String[] lineNames) {
    List<TableCell> row = new ArrayList<TableCell>();
    for (int i = 0; i < lineNames.length; i++) {
      row.add(new TableCell(lineNames[i], entry[0], Integer.parseInt(entry[i + 1])));
    }
    return row;
  }

  public List<TableCell> getTable() {
    return this.table;
  }
}
