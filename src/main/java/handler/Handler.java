package handler;

import java.sql.Connection;

public interface Handler {
  default Connection connection() {
    return null;
  }

  default void startInteraction() {

  }
}
