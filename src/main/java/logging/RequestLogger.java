package logging;

import java.util.logging.Logger;

public class RequestLogger extends LoggerImpl {
  public RequestLogger() {
    this.logger = Logger.getLogger(RequestLogger.class.getName());
  }
}
