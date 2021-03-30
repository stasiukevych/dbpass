package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerImpl implements Logging {
  protected Logger logger;

  public LoggerImpl() {
    this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  }

  @Override
  public void info(String message) {
    logger.info(message);
  }

  @Override
  public void warn(String message) {
    logger.warning(message);
  }

  @Override
  public void error(String message) {
    logger.log(Level.SEVERE, message);
  }
}
