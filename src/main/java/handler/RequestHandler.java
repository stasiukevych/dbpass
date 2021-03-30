package handler;

import controller.ConsoleController;
import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import logging.RequestLogger;

public class RequestHandler implements Handler {
  private Session session;
  private Console console;
  private Connection connection;

  public RequestHandler(final Connection connection) {
    init(connection);
  }

  private void init(final Connection connection) {
    this.connection = connection;
    this.console = System.console();
    this.session = new Session(connection);
  }

  @Override
  public void startInteraction() {
    if (!new ConsoleController(console).possibleForUsing()) {
      return;
    }
    try {
      console
          .printf(String.format(">_ let's start [%s]\n", connection.getMetaData().getUserName()));
    } catch (SQLException throwable) {
      new RequestLogger().error(throwable.getMessage());
      throwable.printStackTrace();
    }
    console.printf(">_ bye \n");
  }
}
