package handler.app;

import java.sql.Connection;
import java.sql.SQLException;

public interface Handler {
  default Connection connection() {
    return null;
  }

  default void startInteraction() throws SQLException { }
}
