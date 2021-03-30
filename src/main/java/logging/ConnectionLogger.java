package logging;

import java.util.logging.Logger;

public class ConnectionLogger extends LoggerImpl {
  public ConnectionLogger() {
    this.logger = Logger.getLogger(ConnectionLogger.class.getName());
  }
}
