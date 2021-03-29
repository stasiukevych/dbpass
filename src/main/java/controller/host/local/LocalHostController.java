package controller.host.local;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import logging.ConnectionLogger;

public class LocalHostController {

  public boolean isReachable(final String host) {
    try {
      final boolean isReachable = InetAddress.getByName(host).isReachable(400);
      ConnectionLogger.info("data base host is a reachable: " + isReachable);
      return isReachable;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean isLocalHost(final String host) {
    String LOCAL_STRING = "localhost";
    String LOCAL_NUMBER = "127.0.0.1";
    boolean isLocalHost = host.equals(LOCAL_STRING) || host.equals(LOCAL_NUMBER);
    ConnectionLogger.info("is a localHost: " + isLocalHost);
    return isLocalHost;
  }

  public boolean isServerUp(final String host, final int port) {
    try (Socket socket = new Socket(host, port)) {
      boolean isServerUp = socket.isConnected();
      ConnectionLogger.info("is a server up: " + isServerUp);
      return isServerUp;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
