package mysql;

import controller.host.controller.MySQLLocalHostController;
import controller.host.local.LocalHostController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MySQLHostControllerTest {

  @Disabled
  @Test
  public void testHostController() {
    MySQLLocalHostController controller = new MySQLLocalHostController(
        new LocalHostController()
    );
    Assertions.assertTrue(controller.isPossible("localhost"));
  }
}
