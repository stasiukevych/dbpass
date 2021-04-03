package handler.sql;

import handler.PasswordCipher;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import logging.SessionLogger;

public class InsertSQLExecutor {
  private static final String INSERT_SERVICE_PASS =
      "insert into password(service,hash) values(?,?)";

  public static void insertPassword(final Connection connection,
                                    String pathToConfiguration) {
    String again;
    do {
      final Console console = System.console();
      final String service = console.readLine(">_ print service: ");
      final String password = String.valueOf(console.readPassword(">_ print password: "));
      final Properties properties = new Properties();
      try {
        properties.load(new FileInputStream(pathToConfiguration));
      } catch (IOException exception) {
        exception.printStackTrace();
      }
      final String hash =
          PasswordCipher.encrypt(
              password,
              properties.getProperty("db_pass_key"),
              properties.getProperty("db_pass_salt")
          );
      try {
        final PreparedStatement statement = connection.prepareStatement(INSERT_SERVICE_PASS);
        statement.setString(1, service);
        statement.setString(2, hash);
        statement.executeUpdate();
        statement.close();
      } catch (SQLException throwable) {
        new SessionLogger().error(throwable.getMessage());
        throwable.printStackTrace();
      }
      again = console.readLine(">_ do you wanna insert (n-no,y-yes) again: ");
    } while (again.equalsIgnoreCase("yes"));
  }
}
