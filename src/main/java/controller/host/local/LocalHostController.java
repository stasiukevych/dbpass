package controller.host.local;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class LocalHostController {
  private final String LOCAL_STRING = "localhost";
  private final String LOCAL_NUMBER = "127.0.0.1";

  public boolean isReachable(final String host) {
    try {
      return InetAddress.getByName(host).isReachable(400);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean isLocalHost(final String host) {
    return host.equals(LOCAL_STRING) || host.equals(LOCAL_NUMBER);
  }

  public boolean isServerUp(final String host, final int port) {
    try (Socket socket = new Socket(host, port)) {
      return socket.isConnected();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
