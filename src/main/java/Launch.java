import connection.vendor.MySQLConnection;
import handler.app.ConnectionHandler;
import handler.app.Handler;
import handler.app.RequestHandler;
import java.sql.SQLException;

public class Launch {
  public static void main(String[] args) throws SQLException {
    final Handler connectionHandler = new ConnectionHandler(
        new MySQLConnection(),
        args[0]
    );
    final Handler requestHandler = new RequestHandler(connectionHandler.connection(), args[0]);
    requestHandler.startInteraction();
  }
}
