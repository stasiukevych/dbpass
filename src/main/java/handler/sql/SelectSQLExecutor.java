package handler.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import logging.SessionLogger;

public class SelectSQLExecutor {
  private static final String SELECT_PASS = "select * from password";

  public static void showTable(final Connection connection) {
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(SELECT_PASS)) {
        showTable(buildTable(resultSet), true);
      }
    } catch (SQLException throwable) {
      new SessionLogger().error(throwable.getMessage());
      throwable.printStackTrace();
    }
  }

  private static String[][] buildTable(ResultSet resultSet) throws SQLException {
    final List<String[]> tbl = new ArrayList<>();
    tbl.add(new String[] {
        resultSet.getMetaData().getColumnName(1),
        resultSet.getMetaData().getColumnName(2),
        resultSet.getMetaData().getColumnName(3),
    });
    while (resultSet.next()) {
      String id = String.valueOf(resultSet.getInt(1));
      String service = resultSet.getString(2);
      String hash = resultSet.getString(3);
      tbl.add(new String[] {id, service, hash});
    }
    String[][] table = new String[tbl.size()][tbl.get(0).length];
    for (String[] row : tbl) {
      table[tbl.indexOf(row)] = row;
    }
    return table;
  }

  private static void showTable(final String[][] table, final boolean justifiedMode) {
    /*
     * Calculate appropriate Length of each column by looking at width of data in
     * each column.
     *
     * Map columnLengths is <column_number, column_length>
     */
    Map<Integer, Integer> columnLengths = new HashMap<>();
    Arrays.stream(table)
        .forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
          columnLengths.putIfAbsent(i, 0);
          if (columnLengths.get(i) < a[i].length()) {
            columnLengths.put(i, a[i].length());
          }
        }));
    /*
     * Prepare format String
     */
    final StringBuilder formatString = new StringBuilder("");
    String flag = justifiedMode ? "-" : "";
    columnLengths.forEach((key, value) -> formatString.append("| %").append(flag).append(value)
        .append("s "));
    formatString.append("|\n");
    /*
     * Prepare line for top, bottom & below header row.
     */
    String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
      String templn = "+-";
      templn = templn +
          Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
              (a1, b1) -> a1 + b1);
      templn = templn + "-";
      return ln + templn;
    }, (a, b) -> a + b);
    line = line + "+\n";

    /*
     * Print table
     */
    System.out.print(line);
    Arrays.stream(table).limit(1).forEach(a -> System.out.printf(formatString.toString(),
        (Object[]) a));
    System.out.print(line);

    Stream.iterate(1, (i -> i < table.length), (i -> ++i))
        .forEach(a -> System.out.printf(formatString.toString(), (Object[]) table[a]));
    System.out.print(line);
  }
}
