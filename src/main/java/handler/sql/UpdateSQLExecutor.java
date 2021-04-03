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

public class UpdateSQLExecutor {
  public static void updatePassword(final Connection connection, final String pathToConfiguration) {
    String exit;
    do {
      final Console console = System.console();
      final String service = console.readLine(">_ print service for updating: ");
      final String password =
          console.readLine(String.format(">_ print new password for [%s]: ", service));
      try {
        final String UPDATE_PASSWORD = "update password set hash = ? where service = ?";
        final PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD);
        final Properties properties = new Properties();
        properties.load(new FileInputStream(pathToConfiguration));
        statement.setString(1,
            PasswordCipher.encrypt(
                password,
                properties.getProperty("db_pass_key"),
                properties.getProperty("db_pass_salt")
            )
        );
        statement.setString(2, service);
        statement.executeUpdate();
        console.printf(String.format(">_ update password for [%s]\n", service));
      } catch (SQLException | IOException throwable) {
        new SessionLogger().error(throwable.getMessage());
        throwable.printStackTrace();
      }
      exit = console.readLine(">_ continue checking (y-yes,n-no): ");
    } while (exit.equalsIgnoreCase("y"));
  }
}
