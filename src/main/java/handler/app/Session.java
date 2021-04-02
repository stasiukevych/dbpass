package handler.app;

import handler.sql.SelectSQLExecutor;
import java.sql.Connection;
import logging.SessionLogger;

public class Session {
  private final Connection connection;

  public Session(final Connection connection) {
    this.connection = connection;
  }

  public void handleSelection(final String selection) {
    switch (selection) {
      case "<show>":
        SelectSQLExecutor.showTable(connection);
        break;
      case "<insert>":
        System.out.println("<isn't implemented>");
      default:
        new SessionLogger().error(">_ command isn't supported");
    }
  }
}
