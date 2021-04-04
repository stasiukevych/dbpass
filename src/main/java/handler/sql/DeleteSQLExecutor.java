package handler.sql;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logging.SessionLogger;

public class DeleteSQLExecutor {
  public static void deletePassword(final Connection connection) {
    String exit;
    do {
      final Console console = System.console();
      final String DELETE_WITH_CONDITION = "delete from password where service = ?";
      final String service = console.readLine(">_ print service for deleting: ");
      try {
        final PreparedStatement statement = connection.prepareStatement(DELETE_WITH_CONDITION);
        statement.setString(1, service);
        statement.execute();
        console.printf(String.format(">_ %s was deleted\n", service));
      } catch (SQLException throwable) {
        new SessionLogger().error(throwable.getMessage());
        throwable.printStackTrace();
      }
      exit = console.readLine(">_ continue deleting (y-yes,n-no): ");
    } while (exit.equalsIgnoreCase("y"));
  }
}
