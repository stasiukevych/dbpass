package mysql;

import controller.dbname.vendor.MySQLDBNameController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MySQLDBNameControllerTest {

  @Disabled
  @Test
  public void testDBNameController() {
    MySQLDBNameController mySQLDBNameController = new MySQLDBNameController();
    Assertions.assertTrue(mySQLDBNameController.isPossible("name"));
  }
}
