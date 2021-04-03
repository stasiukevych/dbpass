package handler.app;

import handler.sql.InsertSQLExecutor;
import handler.sql.SelectSQLExecutor;
import java.io.Console;
import java.sql.Connection;
import logging.SessionLogger;

public class Session {
  private final Connection connection;

  public Session(final Connection connection) {
    this.connection = connection;
  }

  public void handleSelection(final String selection, final String pathToConfiguration,
                              final Console console) {
    switch (selection) {
      case "<show>":
        SelectSQLExecutor.showTable(connection);
        break;
      case "<insert>":
        InsertSQLExecutor.insertPassword(connection, pathToConfiguration);
        break;
      default:
        new SessionLogger().error(">_ command isn't supported");
    }
  }
}
