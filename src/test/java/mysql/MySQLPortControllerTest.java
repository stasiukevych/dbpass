package mysql;

import controller.port.controller.MySQLLocalPortController;
import controller.port.local.LocalPortController;
import controller.port.vendor.MySQLVendorPortController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MySQLPortControllerTest {
  @Disabled
  @Test
  public void testPortController() {
    MySQLLocalPortController controller = new MySQLLocalPortController(
        new LocalPortController(),
        new MySQLVendorPortController()
    );
    Assertions.assertTrue(controller.isPossible(3306));
  }
}
