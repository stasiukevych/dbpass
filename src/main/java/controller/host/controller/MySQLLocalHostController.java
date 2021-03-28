package controller.host.controller;

import constant.MySQLConstant;
import controller.host.HostController;
import controller.host.local.LocalHostController;
import java.io.IOException;
import java.util.concurrent.Executors;

public class MySQLLocalHostController implements HostController {

  private final LocalHostController localHostController;

  public MySQLLocalHostController(LocalHostController localHostController) {
    this.localHostController = localHostController;
  }

  @Override
  public boolean isPossible(String host) {
    return localHostController.isReachable(host) &&
        localHostController.isLocalHost(host) &&
        localHostController.isServerUp(host, MySQLConstant.MYSQL_PORT);
  }
}
