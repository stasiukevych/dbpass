package controller.dbname.vendor;

import controller.dbname.DBNameController;

public class MySQLDBNameController implements DBNameController {

  @Override
  public boolean isPossible(String dbName) {
    final boolean containsSpace = dbName.contains(" ");
    return !containsSpace && dbName.length() <= 64;
  }
}
