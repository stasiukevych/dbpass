import connection.vendor.MySQLConnection;
import handler.ConnectionHandler;
import handler.Handler;

public class Launch {
  public static void main(String[] args) {
    Handler handler = new ConnectionHandler(
        new MySQLConnection(),
        args[0]
    );
  }
}
