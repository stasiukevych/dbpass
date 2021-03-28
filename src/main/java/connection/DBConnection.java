package connection;

import java.sql.Connection;

public interface DBConnection {
  Connection connection(String dbName, String user, String dbPass, int port, String host);
}
