package handler;

import builder.DBPropertiesBuilder;
import connection.vendor.MySQLConnection;
import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import logging.ConnectionLogger;

public class ConnectionHandler implements Handler {
  private Connection connection;
  private String configurationPath;
  private MySQLConnection mySQLConnection;

  public ConnectionHandler(final MySQLConnection mySQLConnection, final String configurationPath) {
    this.mySQLConnection = mySQLConnection;
    this.configurationPath = configurationPath;
    init();
  }

  private void init() {
    final DBPropertiesBuilder dbPropertiesBuilder = new DBPropertiesBuilder(configurationPath);
    final Console console = System.console();
    while (connection == null) {
      connection = mySQLConnection.connection(
          dbPropertiesBuilder.dbName(),
          dbPropertiesBuilder.dbUser(),
          dbPropertiesBuilder.dbPass(),
          dbPropertiesBuilder.dbPort(),
          dbPropertiesBuilder.dbHost()
      );
      if (connection == null) {
        final String answer = console.readLine(">_ do you wanna continue (y-yes,n-no): ");
        if (answer.equalsIgnoreCase("n")) {
          clearConnectionEntity();
          break;
        }
      } else {
        try {
          new ConnectionLogger().info("was connected to " + connection.getCatalog());
        } catch (SQLException throwable) {
          new ConnectionLogger().error(throwable.getMessage());
        }
        console.printf(">_ connection was installed, welcome\n");
      }
    }
  }

  public Connection connection() {
    return connection;
  }

  private void clearConnectionEntity() {
    this.connection = null;
    this.mySQLConnection = null;
    this.configurationPath = null;
  }
}
