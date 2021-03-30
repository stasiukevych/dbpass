package mysql;

import connection.vendor.MySQLConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MySQLConnectionTest {

  @Disabled
  @Test
  public void testConnection() {
    MySQLConnection mySQLConnection = new MySQLConnection();
    Assertions.assertNull(mySQLConnection.connection("name", "user", "pass", 11, "host"));
  }
}
