package controller.driver.vendor;

import constant.MySQLConstant;
import controller.driver.DriverController;

public class MySQLDriverController implements DriverController {
  @Override
  public boolean isPossible() {
    try {
      Class<?> aClass = Class.forName(MySQLConstant.MYSQL_DRIVER);
      return aClass.getName().equals(MySQLConstant.MYSQL_DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return false;
  }
}
