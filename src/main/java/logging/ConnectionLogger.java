package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionLogger {
  static Logger logger;

  static {
    logger = Logger.getLogger(ConnectionLogger.class.getName());
  }

  public static void info(final String message) {
    logger.info(message);
  }

  public static void warn(final String message) {
    logger.warning(message);
  }

  public static void error(final String message) {
    logger.log(Level.SEVERE, message);
  }
}
