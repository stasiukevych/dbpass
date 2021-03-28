package controller.port.local;

import java.io.IOException;
import java.net.Socket;

public class LocalPortController {
  public boolean isServerUp(final String host, final int port) {
    try (Socket socket = new Socket(host, port)) {
      return socket.isConnected();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
