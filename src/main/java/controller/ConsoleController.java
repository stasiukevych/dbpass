package controller;

import java.io.Console;
import logging.ConsoleControllerLogger;

public class ConsoleController {
  private Console console;

  public ConsoleController(final Console console) {
    init(console);
  }

  private void init(final Console console) {
    this.console = console;
  }

  public boolean possibleForUsing() {
    if (console == null) {
      new ConsoleControllerLogger().error("console is a closed");
      return false;
    }
    new ConsoleControllerLogger().info("console is a ready for using");
    return true;
  }
}
