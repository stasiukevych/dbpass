package controller;

import controller.dbname.DBNameController;
import controller.driver.DriverController;
import controller.host.HostController;
import controller.password.PassController;
import controller.port.PortController;

public class ConnectionController {
  private final HostController hostController;
  private final PortController portController;
  private final PassController passController;
  private final DriverController driverController;
  private final DBNameController dbNameController;

  private ConnectionController(Builder builder) {
    this.hostController = builder.hostController;
    this.portController = builder.portController;
    this.passController = builder.passController;
    this.dbNameController = builder.dbNameController;
    this.driverController = builder.driverController;
  }

  public static class Builder {
    private HostController hostController;
    private PortController portController;
    private PassController passController;
    private DriverController driverController;
    private DBNameController dbNameController;

    public Builder driverController(DriverController driverController) {
      this.driverController = driverController;
      return this;
    }

    public Builder dbnameController(DBNameController dbNameController) {
      this.dbNameController = dbNameController;
      return this;
    }

    public Builder hostController(HostController hostController) {
      this.hostController = hostController;
      return this;
    }

    public Builder portController(PortController portController) {
      this.portController = portController;
      return this;
    }

    public Builder passController(PassController passController) {
      this.passController = passController;
      return this;
    }

    public ConnectionController build() {
      return new ConnectionController(this);
    }
  }

  public boolean verified(final String dbName, final String dbPass, int port, String host) {
    return driverController.isPossible()
        && dbNameController.isPossible(dbName)
        && passController.isPossible(dbPass)
        && portController.isPossible(port)
        && hostController.isPossible(host);
  }
}
