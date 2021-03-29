package controller.port.local;

import java.io.IOException;
import java.net.Socket;
import logging.ConnectionLogger;

public class LocalPortController {
  public boolean isServerUp(final String host, final int port) {
    try (Socket socket = new Socket(host, port)) {
      return socket.isConnected();
    } catch (IOException exception) {
      ConnectionLogger.error(exception.getMessage());
      exception.printStackTrace();
    }
    return false;
  }
}
