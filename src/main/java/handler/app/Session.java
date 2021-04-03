package handler.app;

import handler.sql.DeleteSQLExecutor;
import handler.sql.FetchSQLExecutor;
import handler.sql.InsertSQLExecutor;
import handler.sql.SelectSQLExecutor;
import handler.sql.UpdateSQLExecutor;
import java.sql.Connection;
import logging.SessionLogger;

public class Session {
  private final Connection connection;

  public Session(final Connection connection) {
    this.connection = connection;
  }

  public void handleSelection(final String selection, final String pathToConfiguration) {
    switch (selection) {
      case "<show>":
        SelectSQLExecutor.showTable(connection);
        break;
      case "<insert>":
        InsertSQLExecutor.insertPassword(connection, pathToConfiguration);
        break;
      case "<password>":
        FetchSQLExecutor.password(connection, pathToConfiguration);
        break;
      case "<update>":
        UpdateSQLExecutor.updatePassword(connection, pathToConfiguration);
        break;
      case "<delete>":
        DeleteSQLExecutor.deletePassword(connection);
        break;
      default:
        new SessionLogger().error(">_ command isn't supported");
    }
  }
}
