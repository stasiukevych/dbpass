package handler.app;

import java.sql.Connection;

public class Session {
  private Connection connection;

  public Session(final Connection connection) {
    this.connection = connection;
  }

  public void handleSelection(final String selection) {
    System.out.println("you choose:" + selection);
  }
}
