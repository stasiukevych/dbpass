package logging;

import java.util.logging.Logger;

public class SessionLogger extends LoggerImpl {
  public SessionLogger() {
    this.logger = Logger.getLogger(SessionLogger.class.getName());
  }
}
