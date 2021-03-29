package handler;

import java.sql.Connection;

public class RequestHandler implements Handler {
  private Connection connection;

  public RequestHandler(final Connection connection) {
    this.connection = connection;
  }
}
