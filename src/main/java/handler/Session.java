package handler;

import java.sql.Connection;

public class Session {
  private Connection connection;

  public Session(final Connection connection) {
    this.connection = connection;
  }
}
