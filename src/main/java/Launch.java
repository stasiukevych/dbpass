import connection.vendor.MySQLConnection;
import handler.ConnectionHandler;
import handler.Handler;
import handler.RequestHandler;

public class Launch {
  public static void main(String[] args) {
    final Handler connectionHandler = new ConnectionHandler(
        new MySQLConnection(),
        args[0]
    );
    final Handler requestHandler = new RequestHandler(connectionHandler.connection());
    requestHandler.startInteraction();
  }
}
