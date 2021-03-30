package logging;

import java.util.logging.Logger;

public class ConsoleControllerLogger extends LoggerImpl {
  public ConsoleControllerLogger() {
    this.logger = Logger.getLogger(ConsoleControllerLogger.class.getName());
  }
}
