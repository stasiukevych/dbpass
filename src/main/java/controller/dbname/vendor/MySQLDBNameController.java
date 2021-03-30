package controller.dbname.vendor;

import controller.dbname.DBNameController;
import logging.ConnectionLogger;

public class MySQLDBNameController implements DBNameController {

  @Override
  public boolean isPossible(String dbName) {
    new ConnectionLogger().warn(String.format("start verifying the next data base name: %s", dbName));
    final boolean containsSpace = dbName.contains(" ");
    return !containsSpace && dbName.length() <= 64;
  }
}
