package controller.driver.vendor;

import constant.MySQLConstant;
import controller.driver.DriverController;
import logging.ConnectionLogger;

public class MySQLDriverController implements DriverController {
  @Override
  public boolean isPossible() {
    try {
      new ConnectionLogger()
          .warn(String.format("start verifying the next driver: %s", MySQLConstant.MYSQL_DRIVER));
      Class<?> aClass = Class.forName(MySQLConstant.MYSQL_DRIVER);
      new ConnectionLogger()
          .info(String.format("finish verifying the next driver: %s", MySQLConstant.MYSQL_DRIVER));
      return aClass.getName().equals(MySQLConstant.MYSQL_DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return false;
  }
}
