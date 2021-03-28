package builder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class DBPropertiesBuilder {

  private final String dbName;
  private final String dbUser;
  private final String dbPass;
  private final String host;
  private final int port;

  public DBPropertiesBuilder(final String pathToProperty) {
    final Properties properties = new Properties();
    if (Objects.nonNull(pathToProperty)) {
      try {
        properties.load(new FileInputStream(pathToProperty));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new UnsupportedOperationException();
    }
    this.dbName = properties.getProperty("db_name");
    this.dbUser = properties.getProperty("db_user");
    this.dbPass = properties.getProperty("db_pass");
    this.host = properties.getProperty("db_host");
    this.port = Integer.parseInt(properties.getProperty("db_port"));
  }

  public String dbName() {
    return dbName;
  }

  public String dbUser() {
    return dbUser;
  }

  public String dbPass() {
    return dbPass;
  }

  public String dbHost() {
    return host;
  }

  public int dbPort() {
    return port;
  }
}
