package mysql;

import controller.driver.vendor.MySQLDriverController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MySQLDriverControllerTest {

  @Disabled
  @Test
  public void testDriverController() {
    MySQLDriverController driverController = new MySQLDriverController();
    Assertions.assertTrue(driverController.isPossible());
  }
}
