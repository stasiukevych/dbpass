package controller.port.controller;

import constant.MySQLConstant;
import controller.port.PortController;
import controller.port.local.LocalPortController;
import controller.port.vendor.MySQLVendorPortController;

public class MySQLLocalPortController implements PortController {
  private final LocalPortController localPortController;
  private final MySQLVendorPortController mySQLLocalPortController;

  public MySQLLocalPortController(LocalPortController localPortController,
                                  MySQLVendorPortController mySQLLocalPortController) {
    this.localPortController = localPortController;
    this.mySQLLocalPortController = mySQLLocalPortController;
  }

  @Override
  public boolean isPossible(int port) {
    return mySQLLocalPortController.isMySQLVendorPort(port) &&
        localPortController.isServerUp(MySQLConstant.MYSQL_LOCAL_HOST, port);
  }
}
