package handler.sql;

import handler.PasswordCipher;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import logging.SessionLogger;

public class FetchSQLExecutor {
  public static void password(final Connection connection, String pathToConfiguration) {
    String exit;
    do {
      final Console console = System.console();
      final String SELECT_WITH_CONDITION = "select * from password where service = ?";
      final String service = console.readLine(">_ print service for pass: ");
      try {
        final PreparedStatement statement = connection.prepareStatement(SELECT_WITH_CONDITION);
        statement.setString(1, service);
        final ResultSet resultSet = statement.executeQuery();
        final Properties properties = new Properties();
        try {
          properties.load(new FileInputStream(pathToConfiguration));
        } catch (IOException exception) {
          exception.printStackTrace();
        }
        if (resultSet.next()) {
          final String hash = resultSet.getString("hash");
          final String password = PasswordCipher.decrypt(
              hash,
              properties.getProperty("db_pass_key"),
              properties.getProperty("db_pass_salt")
          );
          console.printf(String.format(">_ password for [%s]: %s\n", service, password));
        }
      } catch (SQLException throwable) {
        new SessionLogger().error(throwable.getMessage());
        throwable.printStackTrace();
      }
      exit = console.readLine(">_ continue checking (y-yes,n-no): ");
    } while (exit.equalsIgnoreCase("y"));
  }
}
