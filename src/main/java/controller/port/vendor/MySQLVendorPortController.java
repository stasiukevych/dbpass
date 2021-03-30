package controller.port.vendor;

import constant.MySQLConstant;
import logging.ConnectionLogger;

public class MySQLVendorPortController {
  public boolean isMySQLVendorPort(final int port) {
    new ConnectionLogger().info("Port is a: " + port);
    return port == MySQLConstant.MYSQL_PORT;
  }
}
