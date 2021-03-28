package controller.port.vendor;

import constant.MySQLConstant;

public class MySQLVendorPortController {
  public boolean isMySQLVendorPort(final int port) {
    return port == MySQLConstant.MYSQL_PORT;
  }
}
