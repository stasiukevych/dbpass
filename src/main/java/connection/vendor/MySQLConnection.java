package connection.vendor;

import builder.DBUrlBuilder;
import connection.DBConnection;
import controller.ConnectionController;
import controller.dbname.vendor.MySQLDBNameController;
import controller.driver.vendor.MySQLDriverController;
import controller.host.controller.MySQLLocalHostController;
import controller.host.local.LocalHostController;
import controller.password.DBPassController;
import controller.port.controller.MySQLLocalPortController;
import controller.port.local.LocalPortController;
import controller.port.vendor.MySQLVendorPortController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import logging.ConnectionLogger;

public class MySQLConnection implements DBConnection {

  private final ConnectionController controller;

  public MySQLConnection() {
    controller = new ConnectionController.Builder()
        .driverController(new MySQLDriverController())
        .dbnameController(new MySQLDBNameController())
        .passController(new DBPassController())
        .portController(new MySQLLocalPortController(
            new LocalPortController(),
            new MySQLVendorPortController()
        ))
        .hostController(new MySQLLocalHostController(
            new LocalHostController()
        ))
        .build();
  }

  @Override
  public Connection connection(String dbName, String dbUser, String dbPass, int port, String host) {
    if (controller.verified(dbName, dbPass, port, host)) {
      new ConnectionLogger().info("data base name is a correct: " + dbName);
      new ConnectionLogger().info("data base host is a correct: " + host);
      new ConnectionLogger().info("data base port is a correct: " + port);
      new ConnectionLogger().info("data base user is a " + dbUser);
      try {
        return DriverManager.getConnection(
            DBUrlBuilder.buildURL("mysql", dbName, port, host),
            dbUser,
            dbPass
        );
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
    return null;
  }
}
