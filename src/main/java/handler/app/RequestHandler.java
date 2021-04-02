package handler.app;

import controller.ConsoleController;
import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

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
  public void startInteraction() throws SQLException {
    if (!new ConsoleController(console).possibleForUsing()) {
      return;
    }
    console
        .printf(String.format(">_ let's start [%s]\n", connection.getMetaData().getUserName()));
    while (true) {
      printDBPassMenu(console);
      final String selection = console.readLine(">_ you choice: ");
      if (selection.equalsIgnoreCase("<exit>")) {
        break;
      }
      session.handleSelection(selection);
    }
    console.printf(">_ bye \n");
  }

  private void printDBPassMenu(Console console) {
    console.printf(">_ show status db, print <show>\n");
    console.printf(">_ insert value, print <insert>\n");
    console.printf(">_ update value, print <update>\n");
    console.printf(">_ delete value, print <delete>\n");
    console.printf(">_ if you wanna exist, print <exit>\n");
  }
}
