import builder.DBPropertiesBuilder;
import connection.vendor.MySQLConnection;
import java.sql.Connection;

public class Launch {
  public static void main(String[] args) {
    MySQLConnection mysqlConnection = new MySQLConnection();
    DBPropertiesBuilder dbPropertiesBuilder = new DBPropertiesBuilder(args[0]);
    Connection connection = mysqlConnection.connection(
        dbPropertiesBuilder.dbName(),
        dbPropertiesBuilder.dbUser(),
        dbPropertiesBuilder.dbPass(),
        dbPropertiesBuilder.dbPort(),
        dbPropertiesBuilder.dbHost()
    );
  }
}
